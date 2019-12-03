<?php

namespace CiteBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\DateType;

class ConferenceType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('titreconference')->add('descriptionconference')->add('dateconference')
            ->add('idsalle',EntityType::class,array('class'=>'CiteBundle:Salle','choice_label'=>'numsalle','multiple'=>false))
            ->add('idspeaker',EntityType::class,array('class'=>'CiteBundle:Speaker','choice_label'=>'nomspeaker','multiple'=>false))
            ->add('save',SubmitType::class,['attr'=>['formnovalidate'=>'formnovalidate']]);
    }/**
     * {@inheritdoc}
     */
    #->add('firstDiscoveredAt', DateType::class, ['widget' => 'single_text'])
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'CiteBundle\Entity\Conference'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'citebundle_conference';
    }


}
