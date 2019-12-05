<?php

namespace WebBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\DateTimeType;


class FormationType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('formateurformation')->add('classeformation')->add('prixformation')->add('typeformation')->add('dateformation', DateTimeType::class, array(
            'required' => true,
            'widget' => 'single_text',
            'attr' => [
                'class' => 'form-control input-inline datetimepicker',
                'data-provide' => 'datetimepicker',
                'html5' => false,
            ],
        ))->add('idsalle',EntityType::class,array('class'=>'WebBundle:Salle','choice_label'=>'idsalle','multiple'=>false))
            ->add('save',SubmitType::class,['attr'=>['formnovalidate'=>'formnovalidate']]);

    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'WebBundle\Entity\Formation'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'webbundle_formation';
    }


}
