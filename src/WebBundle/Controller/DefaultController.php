<?php

namespace WebBundle\Controller;

use DateTime;

use Knp\Component\Pager\Paginator;
use Mgilet\NotificationBundle\NotifiableInterface;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use WebBundle\Entity\Formation;
use WebBundle\Entity\Inscription;
use WebBundle\Entity\User;
use WebBundle\Form\FormationType;
use Symfony\Component\HttpFoundation\Response;


class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('Template.html.twig');
    }

    public function meAction()
    {
        return $this->render('base.html.twig');
    }

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
            return $this->redirectToRoute('web_view');
        }
        return $this->render('Formation/new.html.twig', array('f' => $form->createView()));
    }

    public function ReadFAction(Request $request)
    {
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        /**
         * @var $paginator Paginator
         */
        $paginator  = $this->get('knp_paginator');
        $result = $paginator->paginate(
            $formations,
            $request -> query->getInt('page', 1),
            $request -> query->getInt('limit', 5)
        );
        //fetching objects (clubs) from Database

        //add the list of clubs to the render function as input to base
        return $this->render('Formation/ReadF.html.twig', array('formations' => $result));
    }


    public function ReadUFAction()
    {
        //fetching objects (clubs) from Database
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('Formation/ReadFU.html.twig', array('formations' => $formations));
    }

    public function ReadFUDAction($idformation)
    {
        //$em = $this->getDoctrine()->getManager();
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findBy(array('idformation' => $idformation));
        //$inscriptions = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('idformation' => $iduser));


        //return $this->redirectToRoute("web_view2");

        return $this->render('Formation/ReadFUD.html.twig', array('formations' => $formations, 'n' => $idformation));
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
            return $this->redirectToRoute('web_view');
        }

        return $this->render('Formation/update.html.twig', array('f' => $form->createView()));

    }

    public function InscriAction($idform, $iduser)
    {
        $inscriptionss=$this->getDoctrine()->getRepository(Inscription::class)->findInscriptionById($iduser);
        //$inscriptionss = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('iduser' => $iduser));
        $inscriptionsss=$this->getDoctrine()->getRepository(Inscription::class)->findInscriptionByIdd($idform);


        $country = $this->getDoctrine()->getRepository(Formation::class)->find(intval($idform));
        $user = $this->getDoctrine()->getRepository(User::class)->find(intval($iduser));
        $em = $this->getDoctrine()->getManager();
        $myFormation = $this->getDoctrine()->getRepository(Formation::class)->find($idform);
        //$dt = DateTime::createFromFormat("Y-m-d H:i:s", strlen($myFormation->getDateformation()));
        $date   = $myFormation->getDateformation(); //this returns the current date time
        $time = new DateTime();
         $time = $time->diff($myFormation->getDateformation());
        $hours = $time->format('%R%a hours');

        $categorie = $em->getRepository(Formation::class)->find(intval($idform));
        //$f = $this->createForm(categorieType::class,$categorie);
        //$f = $f->handleRequest($request);

        $idd = $this->container->get('security.token_storage')->getToken()->getUser();
        $idd->getId();
        //$iddd= $user->getId();
        $nbr = $categorie->getPrixformation();
        //$categorie->setPrixformation($nbr-1);





        if(($inscriptionss )&& ($inscriptionsss)) {
            echo "<script language='javascript'>";
            echo "if(!alert('tu as deja particper')){
          window.location.reload();}";
            echo "</script>";


    }
        else {
            if ($hours < 3){
                echo "<script language='javascript'>";
                echo "if(!alert('time limit')){
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



        }









        //$this->persist($inscription);
        //$this->flush();

        //$em = $this->getDoctrine()->getManager();
        //$inscription = new Inscription;
        //$inscription=$this->getDoctrine()->getRepository("Inscription:User");
        //$em = $this->getDoctrine()->getManager();

        //$inscription = $em->getRepository(Inscription::class)->find($idform);
        //$inscriptio = $em->getRepository(User::class)->find($iduser);
        //$inscription->setIdformation();
        //$inscription->setIduser($iduser);

        //$user = $this->container->get('security.token_storage')->getToken()->getUser();
        //$user->getId();
        //$inscription->setIduser($user->getId());

        //$em = $this->getDoctrine()->getManager();
        //$em->persist($inscription);
        //$em->flush();
        return $this->render('Formation/Inscri.html.twig', array( 'n' => $idform,'app.user.id' =>$iduser));


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


    public function FeedAction(Request $request)
    {
        $formations = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        $feed=$this->get('eko_feed.feed.manager')->get('article');
        $feed->addFromArray($formations);
                return new Response($feed->render('rss'));


    }







}
