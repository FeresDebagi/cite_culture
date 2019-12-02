<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\Evenement;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use CiteBundle\Entity\History;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;


class HistoryController extends Controller
{
//-----------------------------------------------------Afficher historique----------------------------------------------
    public function ReadHistoryAction(){
        $history=$this->getDoctrine()->getRepository(History::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/History/ReadHistory.html.twig',array('h'=>$history));
    }

//-----------------------------------------------------Ajouter historique----------------------------------------------
    public function CreateHistoryAction(Request $request, $id){
        $response = new Response();
        $em = $this->getDoctrine()->getManager();

        $event = $em->getRepository('CiteBundle:Evenement')->find($id);
        $history = new History();

        $history->setDescriptionHistory($event->getDescriptionEvent());
        $history->setImageHistory($event->getImage());
        $history->setTitreHistory($event->getTitreEvent());
        $history->setIdcategorie($event->getIdcategorie());

        $em->persist($history);
        $em->remove($history);
        $em->flush();

        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        return $this->render('@Cite/Events/ReadEvents.html.twig',array('events'=>$event));
    }
}
