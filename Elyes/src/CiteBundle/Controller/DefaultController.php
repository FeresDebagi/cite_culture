<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\User;
use CiteBundle\Entity\Evenement;
use CiteBundle\Entity\Formation;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use CiteBundle\Entity\Inscription;


class DefaultController extends Controller
{
    public function indexAction()
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        return $this->render('@Cite/Default/index.html.twig',array('events'=>$event));
    }

    public function indexMAction()
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        return $this->render('@Cite/Default/indexM.html.twig',array('events'=>$event));
    }

    public function indexUAction()
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        return $this->render('@Cite/Default/indexU.html.twig',array('events'=>$event));
    }


    public function InscriAction($ideve, $iduser){
        $country = $this->getDoctrine()->getRepository(Evenement::class)->find(intval($ideve));
        $user = $this->getDoctrine()->getRepository(User::class)->find(intval($iduser));
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findBy(array('idEvent'=>$ideve));
        $inscription = new inscription;

        $inscription->setIdevent($country);
        $inscription->setIduser($user);

        $em = $this->getDoctrine()->getManager();
        $em->persist($inscription);
        $em->flush();

        return $this->render('@Cite/Events/Read1EventsU.html.twig',array('events'=>$event,'id'=>$ideve));

    }


}
