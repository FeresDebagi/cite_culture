<?php

namespace CiteBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class SpeakerType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('nomspeaker')->add('prenomspeaker')->add('mailspeaker')->add('datearrive')
            ->add('datedepart')->add('descriptionspeaker')->add('PhotoSpeaker')
            ->add('iduser',EntityType::class,array('class'=>'CiteBundle:User','choice_label'=>'nom','multiple'=>false))
            ->add('save',SubmitType::class,['attr'=>['formnovalidate'=>'formnovalidate']]);
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'CiteBundle\Entity\Speaker'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'citebundle_speaker';
    }


}
