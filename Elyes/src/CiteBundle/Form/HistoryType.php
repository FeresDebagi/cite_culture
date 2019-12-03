<?php

namespace CiteBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use CiteBundle\Entity\History;

class HistoryType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            //->add('descriptionHistory')
            //->add('imageHistory')
            //->add('titreHistory')
            //->add('idcategorie')
            ->add('Submit', SubmitType::class,['attr' => ['formnovalidate' => 'formnovalidate']]);
        ;
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'CiteBundle\Entity\History'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'citebundle_history';
    }


}
