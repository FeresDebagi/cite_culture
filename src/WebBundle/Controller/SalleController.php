<?php

namespace WebBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

use WebBundle\Entity\Inscription;
use WebBundle\Entity\Salle;
use WebBundle\Entity\User;
use WebBundle\Form\SalleType;


class SalleController extends Controller
{
    public function ReadFAction(){
        //fetching objects (clubs) from Database
        $salles=$this->getDoctrine()->getRepository(Salle::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Web/Salle/ReadF.html.twig',array('salle'=>$salles));
    }


    public function createAction(Request $request){
        $salle = new Salle();
        $form = $this->createForm(SalleType::class,$salle);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($salle);
            $em->flush();
            return $this->redirectToRoute('web_viewS');
        }
        return $this->render('@Web/Salle/new.html.twig',array('f'=> $form->createView()));
    }

    public function deleteAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $salle = $em->getRepository(Salle::class)->find($id);
        $em->remove($salle);
        $em->flush();
        return $this->redirectToRoute("web_viewS");
    }


    public function updateAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $salle=$em->getRepository(Salle::class)->find($id);   //recuperer el ligne ta3 el id
        $form = $this->createForm(SalleType::class, $salle);  //taffichi el ligne ta3 el id
        $form = $form->handleRequest($request);

        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($salle);
            $em->flush();
            return $this->redirectToRoute('web_viewS');
        }

        return $this->render('@Web/Salle/update.html.twig',array('f'=> $form->createView()));

    }





}
