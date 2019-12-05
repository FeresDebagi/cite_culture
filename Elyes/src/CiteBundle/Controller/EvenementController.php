<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\Formation;
use CiteBundle\Entity\Inscription;
use CiteBundle\Entity\InscriptionEvent;
use CiteBundle\Entity\User;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use CiteBundle\Entity\Evenement;
use CiteBundle\Entity\Conference;
use CiteBundle\Entity\History;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use CiteBundle\Form\EvenementType;
use CiteBundle\Form\RechercheEventType;
use Symfony\Component\Validator\Constraints\DateTime;


class EvenementController extends Controller
{
//-----------------------------------------------------Affichage Evenement----------------------------------------------
    public function Show1EventMAction($idEvent)
    {
        //$em = $this->getDoctrine()->getManager();
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findBy(array('idEvent'=>$idEvent));
        //return $this->redirectToRoute("web_view2");
        return $this->render('@Cite/Events/Read1EventsM.html.twig',array('events'=>$event,'id'=>$idEvent));
    }

    public function ReadEventsAction(){
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Events/ReadEvents.html.twig',array('events'=>$event));
    }

    public function ReadEventsMAction(){
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Events/ReadEventsM.html.twig',array('events'=>$event));
    }

    public function ReadEventsUAction(){
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Events/ReadEventsU.html.twig',array('events'=>$event));
    }

    public function Show1EventUAction($idEvent)
    {
        //$em = $this->getDoctrine()->getManager();
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findBy(array('idEvent'=>$idEvent));
        //return $this->redirectToRoute("web_view2");
        return $this->render('@Cite/Events/Read1EventsU.html.twig',array('events'=>$event));
    }
//-----------------------------------------------------Ajout Evenement----------------------------------------------
    public function CreateEventAction(Request $request){
        $event = new Evenement;
        $form = $this->createForm(EvenementType::class, $event);
        $form = $form->handleRequest($request);
        if ($form ->isSubmitted() and $form->isValid()){
            $file = $event->getImage();
            $fileName = md5(uniqid()).'.'.$file->guessExtension();
            $file->move($this->getParameter('image_directory'),$fileName);
            $event->setImage($fileName);

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
    public function SendEmailAction(Request $request)
    {
        $em=$this->getDoctrine()->getManager();
        $ticket=$em->getRepository(User::class)->find(1);
        $form = $this->createFormBuilder()
            ->add('message', TextareaType::class)
            ->add('send', SubmitType::class)
            ->getForm();
        $form->handleRequest($request);
        $message = $form["message"]->getData();
        if ($form->isSubmitted() && $form->isValid()) {
            if ($request->isMethod('POST'))
                $email =$this->getUser()->getEmail();
            $message = $form["message"]->getData();
            $message = \Swift_Message::newInstance()
                ->setSubject('Test')
                ->setFrom('test.cite.de.la.culture@gmail.com')
                ->setTo($email)
                ->setCharset('utf-8')
                ->setContentType('text/html')
                ->setBody($message);
            $this->get('mailer')->send($message);
        }
        return $this->render('@Cite/API/ContactUs.html.twig',array('f' => $form->createView()));
    }
//-----------------------------------------------------Inscription--------------------------------------------------

    public function InscriAction($ideve, $iduser)
    {
        $inscriptionss=$this->getDoctrine()->getRepository(InscriptionEvent::class)->findInscriptionByIddE($iduser);
        $inscriptionsss=$this->getDoctrine()->getRepository(InscriptionEvent::class)->findInscriptionEByIdd($ideve);
        $country = $this->getDoctrine()->getRepository(Evenement::class)->find(intval($ideve));
        $user = $this->getDoctrine()->getRepository(User::class)->find(intval($iduser));
        $em = $this->getDoctrine()->getManager();
        $categorie = $em->getRepository(Evenement::class)->find(intval($ideve));
        $idd = $this->container->get('security.token_storage')->getToken()->getUser();
        $idd->getId();
        $nbr = $categorie->getNbrE();

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
            $inscription = new InscriptionEvent();
            $inscription->setIdevent($country);
            $inscription->setIduser($user);
            $categorie->setNbrE($nbr - 1);

            $em = $this->getDoctrine()->getManager();
            $em->persist($inscription);
            $em->flush();
        }
        return $this->render('@Cite/Events/Inscri.html.twig', array( 'n' => $ideve,'app.user.id' =>$iduser));
    }

}
