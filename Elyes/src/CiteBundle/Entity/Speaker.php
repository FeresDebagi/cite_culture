<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Speaker
 *
 * @ORM\Table(name="speaker", indexes={@ORM\Index(name="idU_fk", columns={"idU_fk"})})
 * @ORM\Entity
 */
class Speaker
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_speaker", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSpeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_speaker", type="string", length=255, nullable=true)
     */
    private $nomSpeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom_speaker", type="string", length=255, nullable=true)
     */
    private $prenomSpeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="mail_speaker", type="string", length=255, nullable=true)
     */
    private $mailSpeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="date_arrive", type="string", length=255, nullable=true)
     */
    private $dateArrive;

    /**
     * @var string
     *
     * @ORM\Column(name="date_depart", type="string", length=255, nullable=true)
     */
    private $dateDepart;

    /**
     * @var string
     *
     * @ORM\Column(name="description_speaker", type="string", length=255, nullable=true)
     */
    private $descriptionSpeaker;

    /**
     * @var integer
     *
     * @ORM\Column(name="idU_fk", type="integer", nullable=false)
     */
    private $iduFk;

    /**
     * @var string
     *
     * @ORM\Column(name="PhotoSpeaker", type="string", length=50000, nullable=true)
     */
    private $photospeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="proprietaire_speaker", type="string", length=255, nullable=true)
     */
    private $proprietaireSpeaker;


}

