<?php

namespace CiteBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use CiteBundle\Entity\Foire;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use CiteBundle\Form\FoireType;
use CiteBundle\Entity\Stand;
use CiteBundle\Form\StandType;

class StandController extends Controller
{

    public function ShowStandAction($ref)
    {
        return $this->render('@Cite/Stand/showStand.html.twig',array('r'=>$ref));
    }

    public function ReadStandAction(){
        $stand=$this->getDoctrine()->getRepository(Stand::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Stand/ReadStand.html.twig',array('s'=>$stand));
    }



    public function CreateStandAction(Request $request){
        $stand = new Stand();
        $form = $this->createForm(StandType::class, $stand);
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($stand);
            $em->flush();
            return $this->redirectToRoute('StandRead');
        }
        return $this->render('@Cite/Stand/createStand.html.twig',array('s'=> $form->createView()));
    }


    public function DeleteStandAction($id){
        $em = $this->getDoctrine()->getManager();
        $stand=$em->getRepository(Stand::class)->find($id);
        $em->remove($stand);
        $em->flush();
        return $this->redirectToRoute("StandRead");
    }


    public function UpdateStandAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $stand = $em->getRepository(Stand::class)->find($id);
        $form = $this->createForm(StandType::class, $stand);
        $form = $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($stand);
            $em->flush();
            return $this->redirectToRoute('StandRead');
        }

        return $this->render('@Cite/Stand/updateStand.html.twig', array('s' => $form->createView()));
    }

}
