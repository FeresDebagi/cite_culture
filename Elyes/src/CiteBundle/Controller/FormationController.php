<?php

namespace CiteBundle\Controller;

use DateTime;
use CiteBundle\Entity\Conference;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use CiteBundle\Entity\Formation;
use CiteBundle\Entity\Inscription;
use CiteBundle\Entity\User;
use CiteBundle\Form\FormationType;
use CiteBundle\Entity\Evenement;


class FormationController extends Controller
{
    public function ajoutAction()
    {
        return $this->render('Formation/new.html.twig');
    }

    public function createAction(Request $request)
    {
        $formation = new Formation;
        $form = $this->createForm(FormationType::class, $formation);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($formation);
            $em->flush();
            return $this->redirectToRoute('FormationRead');
        }
        return $this->render('@Cite/Formation/new.html.twig', array('f' => $form->createView()));
    }

    public function ReadFAction()
    {
        //fetching objects (clubs) from Database
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Formation/ReadF.html.twig', array('formations' => $formations));
    }


    public function ReadUFAction()
    {
        //fetching objects (clubs) from Database
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Formation/ReadFU.html.twig', array('formations' => $formations));
    }

    public function ReadFUDAction($idformation)
    {
        //$em = $this->getDoctrine()->getManager();
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findBy(array('idformation' => $idformation));
        //$inscriptions = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('idformation' => $iduser));


        //return $this->redirectToRoute("web_view2");

        return $this->render('@Cite/Formation/ReadFUD.html.twig', array('formations' => $formations, 'n' => $idformation));
    }


    public function deleteAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $formation = $em->getRepository(Formation::class)->find($id);
        $em->remove($formation);
        $em->flush();
        return $this->redirectToRoute("web_view");
    }


    public function updateAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $formation = $em->getRepository(Formation::class)->find($id);   //recuperer el ligne ta3 el id
        $form = $this->createForm(FormationType::class, $formation);  //taffichi el ligne ta3 el id
        $form = $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($formation);
            $em->flush();
            return $this->redirectToRoute('FormationRead');
        }

        return $this->render('@Cite/Formation/update.html.twig', array('f' => $form->createView()));

    }

    public function InscriAction($idform, $iduser)
    {
        $inscriptionss=$this->getDoctrine()->getRepository(Inscription::class)->findInscriptionById($iduser);
        //$inscriptionss = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('iduser' => $iduser));
        $inscriptionsss=$this->getDoctrine()->getRepository(Inscription::class)->findInscriptionByIdd($idform);
        $country = $this->getDoctrine()->getRepository(Formation::class)->find(intval($idform));
        $user = $this->getDoctrine()->getRepository(User::class)->find(intval($iduser));
        $em = $this->getDoctrine()->getManager();
        $categorie = $em->getRepository(Formation::class)->find(intval($idform));
        //$f = $this->createForm(categorieType::class,$categorie);
        //$f = $f->handleRequest($request);
        $idd = $this->container->get('security.token_storage')->getToken()->getUser();
        $idd->getId();
        //$iddd= $user->getId();
        $nbr = $categorie->getPrixformation();
        $time = new DateTime();
        $time = $time->diff($country->getDateformation());
        $hours = $time->format('%R%a hours');


        //$categorie->setPrixformation($nbr-1);
        if(($inscriptionss )&& ($inscriptionsss)) {
            echo "<script language='javascript'>";
            echo "if(!alert('Already Subbed')){
          window.location.reload();}";
            echo "</script>";
        }elseif($nbr == 0){
            echo "<script language='javascript'>";
            echo "if(!alert('No More Places')){
                         window.location.reload();}";
            echo "</script>";
        }
        elseif ($hours < 3){
            echo "<script language='javascript'>";
            echo "if(!alert('Inscription Time ran out')){
          window.location.reload();}";
            echo "</script>";
        }
        else {
            $inscription = new Inscription;
            $inscription->setIdformation($country);
            $inscription->setIduser($user);
            $categorie->setPrixformation($nbr - 1);
            //$inscription->setDateajout();

            $em = $this->getDoctrine()->getManager();
            $em->persist($inscription);
            $em->flush();
        }
        return $this->render('@Cite/Formation/Inscri.html.twig', array( 'n' => $idform,'app.user.id' =>$iduser));
    }

    /**
     * @Route("/send-notification", name="send_notification")
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\RedirectResponse
     */
    public function sendNotification(Request $request)
    {
        $manager = $this->get('mgilet.notification');
        $notif = $manager->createNotification('Hello world !');
        $notif->setMessage('This a notification.');
        $notif->setLink('http://symfony.com/');
        // or the one-line method :
        // $manager->createNotification('Notification subject','Some random text','http://google.fr');

        // you can add a notification to a list of entities
        // the third parameter ``$flush`` allows you to directly flush the entities
        $manager->addNotification(array($this->getUser()), $notif, true);

        return $this->redirectToRoute('homepage');

    }

    public function participerAction($idform,Request $request){
        //$idCategorie
        //$annonceCat=new annonceCat();
        //$f1=$this->createForm(annonceCatType::class, $annonceCat);
        //$f1=$f1->handleRequest($request);
        //$country = $this->getDoctrine()->getRepository(Formation::class)->find(intval($idform));
        //$user = $this->getDoctrine()->getRepository(User::class)->find(intval($iduser));
        $inscription = new Inscription;



        //$inscription->setIdformation($country);
        //$inscription->setIduser($user);
        //$inscription->setDateajout();

        //$em = $this->getDoctrine()->getManager();
        //$em->persist($inscription);
        //$em->flush();

        // $annonceCat->setIdannonceCat(null);

        $em = $this->getDoctrine()->getManager();
        $categorie=$em->getRepository(Formation::class)->find(intval($idform));
        //$f = $this->createForm(categorieType::class,$categorie);
        //$f = $f->handleRequest($request);
        $nbr=$categorie->getPrix();

        //$idannonce=$categorie->getIdAnnonce();
        //$categorie->setPrix($type);
        //$categorie->setDateDebut($date_debut);
        $idd=$this->container->get('security.token_storage')->getToken()->getUser()->getId();
        //$catann=$em->getRepository(annonceCat::class)->findBy(array('idCategorie'=>$idannonce,'User'=>$user));
        //$annonceCat->setUser($user);


        //$annonceCat->setIdCategorie( $idannonce->getId());
        //$categorie->setDatefin($date_fin);
        //$categorie->setPrix($nbr-1);
        //$categorie->setIdAnnonce($idannonce);
        //if($catann==null){
        //   $em= $this->getDoctrine()->getManager();
        //   $em->persist($categorie);
        //  $em->persist($annonceCat);
        //   $em->flush();
        //   return $this->redirectToRoute('authentification',array('f'=>$f));}
        //else{
        //  echo "<script language='javascript'>";
        //  echo "if(!alert('tu es deja particper')){
        //  window.location.reload();}";
        //  echo "</script>";



    }



    public function ReadUUFAction()
    {
        //fetching objects (clubs) from Database
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Formation/ReadFUU.html.twig', array('formations' => $formations));
    }

    public function ReadFUUDAction($idformation)
    {
        //$em = $this->getDoctrine()->getManager();
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findBy(array('idformation' => $idformation));
        //$inscriptions = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('idformation' => $iduser));


        //return $this->redirectToRoute("web_view2");

        return $this->render('@Cite/Formation/ReadFUUD.html.twig', array('formations' => $formations, 'n' => $idformation));
    }



}
