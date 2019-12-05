<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\Evenement;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use CiteBundle\Entity\History;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use CiteBundle\Form\HistoryType;


class HistoryController extends Controller
{
//-----------------------------------------------------Afficher historique----------------------------------------------
    public function ReadHistoryAction(){
        $history=$this->getDoctrine()->getRepository(History::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/History/ReadHistory.html.twig',array('h'=>$history));
    }

    public function ReadHistoryMAction(){
        $history=$this->getDoctrine()->getRepository(History::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/History/ReadHistoryM.html.twig',array('h'=>$history));
    }


    public function Show1HistoryMAction($idHistory)
    {
        //$em = $this->getDoctrine()->getManager();
        $event=$this->getDoctrine()->getRepository(History::class)->findBy(array('idHistory'=>$idHistory));
        //return $this->redirectToRoute("web_view2");
        return $this->render('@Cite/History/Read1HistoryM.html.twig',array('events'=>$event,'idHistory'=>$idHistory));
    }



    public function ReadHistoryUAction(){
        $history=$this->getDoctrine()->getRepository(History::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/History/ReadHistoryU.html.twig',array('h'=>$history));
    }

    public function Show1HistoryUAction($idHistory)
    {
        //$em = $this->getDoctrine()->getManager();
        $event=$this->getDoctrine()->getRepository(History::class)->findBy(array('idHistory'=>$idHistory));
        //return $this->redirectToRoute("web_view2");
        return $this->render('@Cite/History/Read1HistoryU.html.twig',array('events'=>$event,'idHistory'=>$idHistory));
    }


//-----------------------------------------------------Supression Historique----------------------------------------------
    public function DeleteHistoryAction($id){
        $em = $this->getDoctrine()->getManager();
        $event=$em->getRepository(History::class)->find($id);
        $em->remove($event);
        $em->flush();
        return $this->redirectToRoute("HistoryRead");
    }









//-----------------------------------------------------Ajouter historique----------------------------------------------
    public function CreateHistoryAction(Request $request, $id){
        $history = new History;
        $em = $this->getDoctrine()->getManager();
        $event = $em->getRepository(Evenement::class)->find($id);
        $inscription=$this->getDoctrine()->getRepository(Evenement::class)->findByidEvent($id);

        $form = $this->createForm(HistoryType::class, $history);
        $form = $form->handleRequest($request);


        $em = $this->getDoctrine()->getManager();
        $history->setDescriptionHistory($event->getDescriptionEvent());
        $history->setImage($event->getImage());
        $history->setTitreHistory($event->getTitreEvent());
        $history->setIdcategorie($event->getIdcategorie());
        $em->persist($history);
        $em->flush();

        return $this->redirectToRoute('EventsRead');
    }
}
