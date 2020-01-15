<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\Categorie;
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
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use CiteBundle\Form\EvenementType;
use CiteBundle\Form\RechercheEventType;
use Symfony\Component\Serializer\Encoder\JsonEncoder;
use Symfony\Component\Serializer\Encoder\XmlEncoder;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Validator\Constraints\DateTime;


class EvenementMobileController extends Controller
{

    //-----------------------------------------------------Ajout Evenement----------------------------------------------
    public function CreateEventMAction(Request $request){
        $em = $this->getDoctrine()->getManager();
        $event = new Evenement();
        $event->setDescriptionEvent($request->get('descriptionEvent'));
        $event->setTitreEvent($request->get('titreEvent'));
        $date = new \DateTime($request->get('dateEvent'));
        $event->setDateEvent($date);
        $event->setPrixEvent($request->get('prixEvent'));
        $event->setNbrE($request->get('nbrE'));
        $event->setSalleEvent($request->get('salleEvent'));
        $cat =$em->getRepository('CiteBundle:Categorie')->findOneBy(array('typecategorie'=>$request->get('typecategorie')));
        $event->setIdcategorie($cat);
        $em->persist($event);
        $em->flush();
        $serializer = new Serializer([new ObjectNormalizer()]) ;
        $formatted = $serializer->normalize($event);
        return new JsonResponse($formatted);
        // return $this->render('@Cite/Events/createEvent.html.twig',array('f'=> $form->createView()));
    }

    //-----------------------------------------------------Modification Evenement----------------------------------------------
    public function UpdateEventMAction(Request $request, $id)
    {

        $em = $this->getDoctrine()->getManager();
        // $event = new Evenement();
        $event = $em->getRepository(Evenement::class)->find($id);
        //  $event->setIdEvent($id);
        $event->setDescriptionEvent($request->get('descriptionEvent'));
        $event->setTitreEvent($request->get('titreEvent'));
        $date = new \DateTime($request->get('dateEvent'));
        $event->setDateEvent($date);
        $event->setPrixEvent($request->get('prixEvent'));
        $event->setNbrE($request->get('nbrE'));
        $event->setSalleEvent($request->get('salleEvent'));
        $cat =$em->getRepository('CiteBundle:Categorie')->findOneBy(array('typecategorie'=>$request->get('typecategorie')));
        $event->setIdcategorie($cat);
        $em->persist($event);
        $em->flush();
        $serializer = new Serializer([new ObjectNormalizer()]) ;
        $formatted = $serializer->normalize($event);
        return new JsonResponse($formatted);
    }

    //-----------------------------------------------------Supression Evenement----------------------------------------------
    public function DeleteMEventAction($id){
        $em = $this->getDoctrine()->getManager();
        $event=$em->getRepository(Evenement::class)->find($id);
        $em->remove($event);
        $em->flush();
        //return $this->redirectToRoute("EventsRead");
        $serializer = new Serializer([new ObjectNormalizer()]) ;
        $formatted = $serializer->normalize($event);
        return new JsonResponse($formatted);
    }

    //-----------------------------------------------------Affichage Evenement----------------------------------------------

    public function ReadMEventsAction(){
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        $serializer = new Serializer([new ObjectNormalizer()]) ;
        $formatted = $serializer->normalize($event);
        return new JsonResponse($formatted);

        //return $this->render('@Cite/Events/ReadEvents.html.twig',array('events'=>$event));
    }

    //-----------------------------------------------------Affichage Categorie----------------------------------------------
    public function ReadMCategorieAction(){
        $event=$this->getDoctrine()->getRepository(Categorie::class)->findAll();
        $serializer = new Serializer([new ObjectNormalizer()]) ;
        $formatted = $serializer->normalize($event);
        return new JsonResponse($formatted);
        //   return $this->render('@Cite/Categories/ReadCategories.html.twig',array('events'=>$event));
    }

//-----------------------------------------------------Afficher historique----------------------------------------------
    public function ReadMHistoryAction(){
        $history=$this->getDoctrine()->getRepository(History::class)->findAll();
         $serializer = new Serializer([new ObjectNormalizer()]) ;
         $formatted = $serializer->normalize($history);
         return new JsonResponse($formatted);
    }

//-----------------------------------------------------Inscrit Event----------------------------------------------

    public function InscriEventMAction($ideve, $iduser)
    {
        $inscriptionss=$this->getDoctrine()->getRepository(InscriptionEvent::class)->findInscriptionByIddE($iduser);
        $inscriptionsss=$this->getDoctrine()->getRepository(InscriptionEvent::class)->findInscriptionEByIdd($ideve);
        $country = $this->getDoctrine()->getRepository(Evenement::class)->find(intval($ideve));
        $user = $this->getDoctrine()->getRepository(User::class)->find(intval($iduser));
        $em = $this->getDoctrine()->getManager();
        $categorie = $em->getRepository(Evenement::class)->find(intval($ideve));
       // $idd = $this->container->get('security.token_storage')->getToken()->getUser();
       // $idd->getId();
        $nbr = $categorie->getNbrE();

        if(($inscriptionss )&& ($inscriptionsss)) {
            $inscription = new InscriptionEvent();
            $event = new Evenement();
            $event->setIdEvent(1);
            $inscription->setIdevent($event);
            $user =new User();
            $user->setId(1);
            $inscription->setIduser($user);
            $serializer = new Serializer([new ObjectNormalizer()]) ;
            $formatted = $serializer->normalize(1);
            return new JsonResponse($formatted);
            //echo "<script language='javascript'>";
         //   echo "if(!alert('Already Subbed')){
          //window.location.reload();}";
           // echo "</script>";
        }elseif($nbr == 0){
            $inscription = new InscriptionEvent();
            $event = new Evenement();
            $event->setIdEvent(0);
            $inscription->setIdevent($event);
            $user =new User();
            $user->setId(0);
            $inscription->setIduser($user);
            $serializer = new Serializer([new ObjectNormalizer()]) ;
            $formatted = $serializer->normalize(0);
            return new JsonResponse($formatted);
        }else{
            $inscription = new InscriptionEvent();
            $inscription->setIdevent($country);
            $inscription->setIduser($user);
            $categorie->setNbrE($nbr - 1);

            $em = $this->getDoctrine()->getManager();
            $em->persist($inscription);
            $em->flush();
        }
        $serializer = new Serializer([new ObjectNormalizer()]) ;
        $formatted = $serializer->normalize(2);
        return new JsonResponse($formatted);
    }

//-----------------------------------------------------Search Event----------------------------------------------

    public function SearchEventMAction(Request $request){


            $formations = $this -> getDoctrine()
                -> getRepository(Evenement::class)
                ->findBy(array('titreEvent'=> ($request->get('titreEvent'))));

        $serializer = new Serializer([new ObjectNormalizer()]) ;
        $formatted = $serializer->normalize($formations);
        return new JsonResponse($formatted);
    }


    //----------------------------------------------------- LOGINN----------------------------------------------

    public function loginMAction($username,$password)
    {
        $user_manager = $this->get('fos_user.user_manager');
        $factory = $this->get('security.encoder_factory');
        $user = $user_manager->findUserByUsername($username);
        $encoders = array(new XmlEncoder(), new JsonEncoder());

        $normalizer = new ObjectNormalizer();
        $normalizer->setCircularReferenceLimit(2);
// Add Circular reference handler
        $normalizer->setCircularReferenceHandler(function ($object) {
            return $object;
        });
        $normalizers = array($normalizer);
        $encoder = $factory->getEncoder($user);
        $users = $this->getDoctrine()->getRepository(User::class)->findBy(array('username'=>$username));
        $bool = ($encoder->isPasswordValid($user->getPassword(),$password,$user->getSalt())) ? "true" : "false";
        if($bool == "true" )
        {
            $serializer = new Serializer($normalizers, $encoders);
            $formatted = $serializer->normalize($users);
            return new JsonResponse($formatted);
        }
        else
        {
            $serializer = new Serializer([new ObjectNormalizer()]);
            $formatted = $serializer->normalize(0);
            return new JsonResponse($formatted);
        }
    }









//-----------------------------------------------------Affichage Evenement----------------------------------------------
    public function Show1EventMAction($idEvent)
    {
        //$em = $this->getDoctrine()->getManager();
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findBy(array('idEvent'=>$idEvent));
        $serializer = new Serializer([new ObjectNormalizer()]) ;
        $formatted = $serializer->normalize($event);
        return new JsonResponse($formatted);
        ///return $this->redirectToRoute("web_view2");
       // return $this->render('@Cite/Events/Read1EventsM.html.twig',array('events'=>$event,'id'=>$idEvent));
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
            echo "if(!alert('Already Subbed')){
          window.location.reload();}";
            echo "</script>";
        }elseif($nbr == 0){
            echo "<script language='javascript'>";
            echo "if(!alert('No More Places Left')){
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

//-----------------------------------------------------MOBILEE ----------------------------------------------


}
