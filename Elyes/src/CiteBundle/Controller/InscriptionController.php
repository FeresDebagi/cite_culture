<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\InscriptionConference;
use CiteBundle\Entity\InscriptionEvent;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

use Symfony\Component\Security\Core\User\UserInterface;
use CiteBundle\Entity\Inscription;
use CiteBundle\Entity\Salle;
use CiteBundle\Entity\User;
use CiteBundle\Form\SalleType;


class InscriptionController extends Controller
{

    public function ReadInscriptionAction(){
        //fetching objects (clubs) from Database
        $inscriptionss=$this->getDoctrine()->getRepository(Inscription::class)->findAll();
        $inscriptionss2=$this->getDoctrine()->getRepository(InscriptionEvent::class)->findAll();
        $inscriptionss3=$this->getDoctrine()->getRepository(InscriptionConference::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Inscription/ReadInscription.html.twig',
            array('formations' => $inscriptionss,'evenement' => $inscriptionss2,'conference' => $inscriptionss3));
    }

    public function ReadMyInscriptionAction()
    {
        //$em = $this->getDoctrine()->getManager();
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $inscriptionss=$this->getDoctrine()->getRepository(Inscription::class)->findInscriptionById($user);
        $inscriptionss2=$this->getDoctrine()->getRepository(InscriptionEvent::class)->findInscriptionByIddE($user);
        $inscriptionss3=$this->getDoctrine()->getRepository(InscriptionConference::class)->findInscriptionByIddC($user);
        $formations = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('iduser' => $user));
        //$inscriptions = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('idformation' => $iduser));
        //return $this->redirectToRoute("web_view2");
        return $this->render('@Cite/Inscription/ReadMyInscription.html.twig',
            array('formations' => $inscriptionss,'evenement' => $inscriptionss2,'conference' => $inscriptionss3));
    }


    public function deleteinscriAction($idinscription)
    {
        $em = $this->getDoctrine()->getManager();
        $inscription = $em->getRepository(Inscription::class)->find($idinscription);
        $em->remove($inscription);
        $em->flush();
        return $this->redirectToRoute("My_Inscriptions");
    }

    public function deleteinscriEventAction($idinscription)
    {
        $em = $this->getDoctrine()->getManager();
        $inscription = $em->getRepository(InscriptionEvent::class)->find($idinscription);
        $em->remove($inscription);
        $em->flush();
        return $this->redirectToRoute("My_Inscriptions");
    }









}
