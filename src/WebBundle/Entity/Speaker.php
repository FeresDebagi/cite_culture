<?php

namespace WebBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Speaker
 *
 * @ORM\Table(name="speaker", indexes={@ORM\Index(name="idU_fk", columns={"iduser"})})
 * @ORM\Entity
 */
class Speaker
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idspeaker", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idspeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="nomspeaker", type="string", length=255, nullable=true)
     */
    private $nomspeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="prenomspeaker", type="string", length=255, nullable=true)
     */
    private $prenomspeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="mailspeaker", type="string", length=255, nullable=true)
     */
    private $mailspeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="datearrive", type="string", length=255, nullable=true)
     */
    private $datearrive;

    /**
     * @var string
     *
     * @ORM\Column(name="datedepart", type="string", length=255, nullable=true)
     */
    private $datedepart;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionspeaker", type="string", length=255, nullable=true)
     */
    private $descriptionspeaker;

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

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="iduser", referencedColumnName="iduser")
     * })
     */
    private $iduser;


}

