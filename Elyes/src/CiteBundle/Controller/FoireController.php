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

class FoireController extends Controller
{

    public function ShowFoireAction($ref)
    {
        return $this->render('@Cite/Foire/showFoire.html.twig',array('r'=>$ref));
    }

    public function ReadFoireAction(){
        $foire=$this->getDoctrine()->getRepository(Foire::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Foire/ReadFoire.html.twig',array('f'=>$foire));
    }



    public function ReadFUAction(){
        $foire=$this->getDoctrine()->getRepository(Foire::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Foire/ReadFU.html.twig',array('f'=>$foire));
    }

    public function ReadFoireMAction(){
        $foire=$this->getDoctrine()->getRepository(Foire::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Foire/ReadFM.html.twig',array('f'=>$foire));
    }


    public function CreateFoireAction(Request $request){
        $foire = new Foire;
        $form = $this->createForm(FoireType::class, $foire);
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $file = $foire->getImage();
            $fileName = md5(uniqid()).'.'.$file->guessExtension();
            $file->move(
                $this->getParameter('image_directory'),$fileName
            );
            $foire->setImage($fileName);
            $em = $this->getDoctrine()->getManager();
            $em->persist($foire);
            $em->flush();
            return $this->redirectToRoute('FoireRead');
        }
        return $this->render('@Cite/Foire/createFoire.html.twig',array('f'=> $form->createView()));
    }


    public function DeleteFoireAction($id){
        $em = $this->getDoctrine()->getManager();
        $foire=$em->getRepository(Foire::class)->find($id);
        $em->remove($foire);
        $em->flush();
        return $this->redirectToRoute("FoireRead");
    }


    public function UpdateFoireAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $foire = $em->getRepository(Foire::class)->find($id);
        $form = $this->createForm(FoireType::class, $foire);
        $form = $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($foire);
            $em->flush();
            return $this->redirectToRoute('FoireRead');
        }

        return $this->render('@Cite/Foire/updateFoire.html.twig', array('f' => $form->createView()));
    }

}
