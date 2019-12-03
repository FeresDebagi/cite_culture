<?php

namespace CiteBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use CiteBundle\Entity\Stand;


class FoireType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('descriptionFoire')->add('imageFoire')->add('titreFoire')->
        add('dateFoire')->add('heureFoire')->add('prixFoire')->add('salleFoire')->add('userNameFoire')
            ->add('idStand', EntityType::class,array('class'=>'CiteBundle:Stand','choice_label'=> 'titreStand', 'multiple'=> false))



            ->add('Submit', SubmitType::class,['attr' => ['formnovalidate' => 'formnovalidate']]);
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'CiteBundle\Entity\Foire'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'Citebundle_Foire';
    }


}
