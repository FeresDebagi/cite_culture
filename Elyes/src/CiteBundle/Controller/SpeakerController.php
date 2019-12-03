<?php

namespace CiteBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use CiteBundle\Entity\Speaker;
use CiteBundle\Form\SpeakerType;

class SpeakerController extends Controller
{
    public function indexAction()
    {
        return $this->render('Template.html.twig');
    }

    public function ajouterAction()
    {
        return $this->render('@Cite/Speaker/speaker.html.twig');
    }

    public function speakercreateAction(Request $request){
        $speaker = new Speaker;
        $form = $this->createForm(SpeakerType::class,$speaker);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($speaker);
            $em->flush();
            return $this->redirectToRoute('speaker_view');
        }
        return $this->render('@Cite/Speaker/speakercreate.html.twig',array('f'=> $form->createView()));
    }

    public function speakerAction(){
        //fetching objects (clubs) from Database
        $speakers=$this->getDoctrine()->getRepository(Speaker::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Speaker/speakerread.html.twig',array('speak'=>$speakers));
    }



    public function speakerdeleteAction($id){
        $em = $this->getDoctrine()->getManager();
        $speaker=$em->getRepository(Speaker::class)->find($id);
        $em->remove($speaker);
        $em->flush();
        return $this->redirectToRoute("speaker_view");
    }


    public function speakerupdateAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $speaker=$em->getRepository(Speaker::class)->find($id);   //recuperer el ligne ta3 el id
        $form = $this->createForm(SpeakerType::class, $speaker);  //taffichi el ligne ta3 el id
        $form = $form->handleRequest($request);

        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($speaker);
            $em->flush();
            return $this->redirectToRoute("speaker_view");
        }

        return $this->render('@Cite/Speaker/speakerupdate.html.twig',array('f'=> $form->createView()));

    }


    public function speakerMAction(){
        //fetching objects (clubs) from Database
        $speakers=$this->getDoctrine()->getRepository(Speaker::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Speaker/speakerM.html.twig',array('speak'=>$speakers));
    }


    public function speakerMDAction($idspeaker)
    { $speakers=$this->getDoctrine()->getRepository(Speaker::class)
        ->findBy(array('idspeaker'=>$idspeaker));
        return $this->render('@Cite/Speaker/speakerMD.html.twig',array('speak'=>$speakers,'n'=>$idspeaker));
    }




    public function speakerUAction(){
        //fetching objects (clubs) from Database
        $speakers=$this->getDoctrine()->getRepository(Speaker::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Speaker/speakerU.html.twig',array('speak'=>$speakers));
    }


    public function speakerUDAction($idspeaker)
    { $speakers=$this->getDoctrine()->getRepository(Speaker::class)
        ->findBy(array('idspeaker'=>$idspeaker));
        return $this->render('@Cite/Speaker/speakerUD.html.twig',array('speak'=>$speakers,'n'=>$idspeaker));
    }


}
