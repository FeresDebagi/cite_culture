<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\User;
use CiteBundle\Entity\Evenement;
use CiteBundle\Entity\Formation;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use CiteBundle\Entity\Inscription;


class DefaultController extends Controller
{
//-----------------------------------------------------Home Page Admin--------------------------------------------------
    public function indexAction()
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        return $this->render('@Cite/Default/index.html.twig',array('events'=>$event));
    }

//-----------------------------------------------------Home Page Member--------------------------------------------------

    public function indexMAction()
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        return $this->render('@Cite/Default/indexM.html.twig',array('events'=>$event));
    }

//-------------------------------------------------------Home Page Simple User------------------------------------------------

    public function indexUAction()
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        return $this->render('@Cite/Default/indexU.html.twig',array('events'=>$event));
    }




    public function ProfilesAdiminAction()
    {
        $event=$this->getDoctrine()->getRepository(User::class)->findAll();
        return $this->render('@Cite/Profiles/ProfilesAdmin.html.twig',array('events'=>$event));
    }



}
