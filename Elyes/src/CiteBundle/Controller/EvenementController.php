<?php

namespace CiteBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use CiteBundle\Entity\Evenement;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use CiteBundle\Form\EvenementType;
use CiteBundle\Form\RechercheEventType;




class EvenementController extends Controller
{
//-----------------------------------------------------Affichage Evenement----------------------------------------------
    public function ShowEventAction($idEvent)
    {
        //$em = $this->getDoctrine()->getManager();
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findBy(array('idEvent'=>$idEvent));

        //return $this->redirectToRoute("web_view2");
        return $this->render('@Cite/Events/Read1EventsU.html.twig',array('events'=>$event,'id'=>$idEvent));
    }

    public function ReadEventsAction(){
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Events/ReadEvents.html.twig',array('events'=>$event));
    }

    public function ReadEventsUAction(){
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Events/ReadEventsU.html.twig',array('events'=>$event));
    }

//-----------------------------------------------------Ajout Evenement----------------------------------------------
    public function CreateEventAction(Request $request){
        $event = new Evenement;
        $form = $this->createForm(EvenementType::class, $event);
        $form = $form->handleRequest($request);
        if ($form ->isSubmitted() and $form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($event);
            $em->flush();
            return $this->redirectToRoute('EventsRead');
        }
        return $this->render('@Cite/Events/createEvent.html.twig',array('f'=> $form->createView()));
    }

//-----------------------------------------------------Supression Evenement----------------------------------------------
    public function DeleteEventAction($id){
        $em = $this->getDoctrine()->getManager();
        $event=$em->getRepository(Evenement::class)->find($id);
        $em->remove($event);
        $em->flush();
        return $this->redirectToRoute("EventsRead");
    }

//-----------------------------------------------------Modification Evenement----------------------------------------------
    public function UpdateEventAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $event = $em->getRepository(Evenement::class)->find($id);
        $form = $this->createForm(EvenementType::class, $event);
        $form = $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($event);
            $em->flush();
            return $this->redirectToRoute('EventsRead');
        }

        return $this->render('@Cite/Events/updateEvent.html.twig', array('f' => $form->createView()));
    }



//-----------------------------------------------------Recherche Evenement----------------------------------------------
    public function SearchEventAction(Request $request){
        $event = new Evenement;
        $form = $this -> createForm(RechercheEventType::class,$event);
        $form ->handleRequest($request);
        if ($form->isSubmitted()){
            $formations = $this -> getDoctrine()
                -> getRepository(Evenement::class)
                ->findBy(array('titreEvent'=> $event ->getTitreEvent()));
        }else{
            $formations = $this ->getDoctrine()->getRepository(Evenement::class)->findAll();
        }

        return $this->render('@Cite/Events/rechercheEvenement.html.twig', array("form"=>$form->createView(),
            'e'=>$formations));
    }

//-----------------------------------------------------Envoyer un mail----------------------------------------------

    public function SendMailAction($id, \Swift_Mailer $mailer)
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        $message = (new \Swift_Message('You got mail'))
            ->setFrom('las1996@gmail.com')
            ->setTo('las1996@gmail.com')
            ->setBody(
                $this->renderView(
                // app/Resources/views/Emails/registration.html.twig
                    '@Cite/Emails/registration.html.twig',
                    array('name' => $id)
                ),
                'text/html'
            );

        $mailer -> send($message);


        return $this->render('@Cite/Events/ReadCategories.html.twig',array('events'=>$event));
    }
}
