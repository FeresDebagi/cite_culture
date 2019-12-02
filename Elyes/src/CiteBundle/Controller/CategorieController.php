<?php

namespace CiteBundle\Controller;

use CiteBundle\Entity\Categorie;
use CiteBundle\Form\CategorieType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class CategorieController extends Controller
{
//-----------------------------------------------------Affichage Categorie----------------------------------------------
    public function ReadCategorieAction(){
        $event=$this->getDoctrine()->getRepository(Categorie::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Cite/Categories/ReadCategories.html.twig',array('events'=>$event));
    }

//--------------------------------------------------------Ajout Categorie----------------------------------------------
    public function CreateCategorieAction(Request $request){
        $event = new Categorie;
        $form = $this->createForm(CategorieType::class, $event);
        $form = $form->handleRequest($request);
        if ($form ->isSubmitted() and $form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($event);
            $em->flush();
            return $this->redirectToRoute('CategorieRead');
        }
        return $this->render('@Cite/Categories/createCategorie.html.twig',array('f'=> $form->createView()));
    }

//-----------------------------------------------------Supression Evenement----------------------------------------------
    public function DeleteCategorieAction($id){
        $em = $this->getDoctrine()->getManager();
        $event=$em->getRepository(Categorie::class)->find($id);
        $em->remove($event);
        $em->flush();
        return $this->redirectToRoute("CategorieRead");
    }

//-----------------------------------------------------Modification Evenement----------------------------------------------
    public function UpdateCategorieAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $event = $em->getRepository(Categorie::class)->find($id);
        $form = $this->createForm(CategorieType::class, $event);
        $form = $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($event);
            $em->flush();
            return $this->redirectToRoute('CategorieRead');
        }

        return $this->render('@Cite/Categories/updateCategorie.html.twig', array('f' => $form->createView()));
    }

}
