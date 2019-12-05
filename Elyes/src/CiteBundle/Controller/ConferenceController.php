<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\Evenement;
use CiteBundle\Entity\Formation;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use CiteBundle\Entity\Conference;
use CiteBundle\Entity\User;
use CiteBundle\Entity\InscriptionConference;
use CiteBundle\Form\ConferenceType;

class ConferenceController extends Controller
{
    public function indexAction()
    {
        return $this->render('Template.html.twig');
    }

    public function ajoutAction()
    {
        return $this->render('@Cite/Conference/new.html.twig');
    }

    public function createAction(Request $request){
        $conference = new Conference;
        $form = $this->createForm(ConferenceType::class,$conference);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $file = $conference->getImage();
            $fileName = md5(uniqid()).'.'.$file->guessExtension();
            $file->move(
                $this->getParameter('image_directory'),$fileName
            );
            $conference->setImage($fileName);

            $em = $this->getDoctrine()->getManager();
            $em->persist($conference);
            $em->flush();
            return $this->redirectToRoute('web_view');
        }
        return $this->render('@Cite/Conference/new.html.twig',array('f'=> $form->createView()));
    }

    public function ReadFAction(){
        //fetching objects (clubs) from Database
        $conferences=$this->getDoctrine()->getRepository(Conference::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Conference/ReadF.html.twig',array('conf'=>$conferences));
    }

    public function InscriptionAction($idconference, $iduser)
    {   $inscription = new Inscription;
        $conf = $this->getDoctrine()->getRepository(Conference::class)->find(intval($idconference));
        $user = $this->getDoctrine()->getRepository(User::class)->find(intval($iduser));
        $inscription->setIdconference($conf);
        $inscription->setIduser($user);
        $em = $this->getDoctrine()->getManager();
        $em->persist($inscription);
        $em->flush();
        return $this->render('@Cite/Conference/confinscri.html.twig');
    }

    public function InscriAction($idconference, $iduser)
    {
        $inscriptionss=$this->getDoctrine()->getRepository(InscriptionConference::class)->findInscriptionById($iduser);
        $inscriptionsss=$this->getDoctrine()->getRepository(InscriptionConference::class)->findInscriptionCByIdd($idconference);
        $country = $this->getDoctrine()->getRepository(Conference::class)->find(intval($idconference));
        $user = $this->getDoctrine()->getRepository(User::class)->find(intval($iduser));
        $em = $this->getDoctrine()->getManager();
        $categorie = $em->getRepository(Conference::class)->find(intval($idconference));
        $idd = $this->container->get('security.token_storage')->getToken()->getUser();
        $idd->getId();
        $nbr = $categorie->getNbrf();
        if(($inscriptionss )&& ($inscriptionsss)) {
            echo "<script language='javascript'>";
            echo "if(!alert('tu es deja particper')){
                 window.location.reload();}";
            echo "</script>";
        }elseif($nbr == 0){
            echo "<script language='javascript'>";
            echo "if(!alert('Full')){
             window.location.reload();}";
            echo "</script>";
        }else{
            $inscription = new InscriptionConference;
            $inscription->setIdconference($country);
            $inscription->setIduser($user);
            $categorie->setNbrf($nbr - 1);

            $em = $this->getDoctrine()->getManager();
            $em->persist($inscription);
            $em->flush();
        }
        return $this->render('@Cite/Conference/Inscri.html.twig', array( 'n' => $idconference,'app.user.id' =>$iduser));
    }

    public function deleteAction($id){
        $em = $this->getDoctrine()->getManager();
        $conference=$em->getRepository(Conference::class)->find($id);
        $em->remove($conference);
        $em->flush();
        return $this->redirectToRoute("web_view");
    }


    public function updateAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $conference=$em->getRepository(Conference::class)->find($id);   //recuperer el ligne ta3 el id
        $form = $this->createForm(ConferenceType::class, $conference);  //taffichi el ligne ta3 el id
        $form = $form->handleRequest($request);

        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($conference);
            $em->flush();
            return $this->redirectToRoute('web_view');
        }
        return $this->render('@Cite/Conference/update.html.twig',array('f'=> $form->createView()));

    }

    public function ReadCMAction(){
        //fetching objects (clubs) from Database
        $conferences=$this->getDoctrine()->getRepository(Conference::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Conference/ReadCM.html.twig',array('conf'=>$conferences));
    }
    public function ReadCMDAction($idconference )
    { $conferences=$this->getDoctrine()->getRepository(Conference::class)
        ->findBy(array('idconference'=>$idconference));
        return $this->render('@Cite/Conference/conferenceDetailsM.html.twig',array('conf'=>$conferences,'n'=>$idconference));
    }


    public function ReadCUAction(){
        //fetching objects (clubs) from Database
        $conferences=$this->getDoctrine()->getRepository(Conference::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Conference/ReadCU.html.twig',array('conf'=>$conferences));
    }
    public function ReadCUDAction($idconference )
    { $conferences=$this->getDoctrine()->getRepository(Conference::class)
        ->findBy(array('idconference'=>$idconference));
        return $this->render('@Cite/Conference/conferenceDetailsU.html.twig',array('conf'=>$conferences,'n'=>$idconference));
    }




}
