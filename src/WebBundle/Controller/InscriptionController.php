<?php

namespace WebBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

use Symfony\Component\Security\Core\User\UserInterface;
use WebBundle\Entity\Inscription;
use WebBundle\Entity\Salle;
use WebBundle\Entity\User;
use WebBundle\Form\SalleType;


use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;



class InscriptionController extends Controller
{
    public function ReadIAction(){
        //fetching objects (clubs) from Database
        $inscription=$this->getDoctrine()->getRepository(Inscription::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Web/Inscription/ReadI.html.twig',array('inscription'=>$inscription));
    }

    public function ReadIUAction()
    {

        //$em = $this->getDoctrine()->getManager();
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $inscriptionss=$this->getDoctrine()->getRepository(Inscription::class)->findInscriptionById($user);
        $formations = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('iduser' => $user));
        //$inscriptions = $this->getDoctrine()->getRepository(Inscription::class)->findBy(array('idformation' => $iduser));


        //return $this->redirectToRoute("web_view2");

        return $this->render('@Web/Inscription/ReadIU.html.twig', array('formations' => $inscriptionss));
    }

    public function deleteinscriAction($idinscription)
    {
        $em = $this->getDoctrine()->getManager();
        $inscription = $em->getRepository(Inscription::class)->find($idinscription);
        $em->remove($inscription);
        $em->flush();
        return $this->redirectToRoute("web_ReadIU");
    }

    public function SendEmail1Action(Request $request)
    {
        $em=$this->getDoctrine()->getManager();

        $ticket=$em->getRepository(User::class)->find(1);

        $form = $this->createFormBuilder()
            ->add('message', TextareaType::class)
            ->add('email', TextareaType::class)
            ->add('send', SubmitType::class)
            ->getForm();
        $form->handleRequest($request);
        $message = $form["message"]->getData();

        if ($form->isSubmitted() && $form->isValid()) {
            if ($request->isMethod('POST'))
                $email =$form["email"]->getData();
            $message = $form["message"]->getData();
            $message = \Swift_Message::newInstance()
                ->setSubject('Response from admin Smart Start')
                ->setFrom('koussaybenhfaidh@gmail.com')
                ->setTo($email)
                ->setCharset('utf-8')
                ->setContentType('text/html')
                ->setBody($message);
            $this->get('mailer')->send($message);

            //return $this->render('@Annonce/Default/ContactUs.html.twig', array('f' => $form->createView()));


        }
        return $this->render('@Web/Inscription/Mail.html.twig',array('f' => $form->createView()));

    }








}
