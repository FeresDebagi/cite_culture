<?php

namespace WebBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Conference
 *
 * @ORM\Table(name="conference", indexes={@ORM\Index(name="IdSalle", columns={"IdSalle"}), @ORM\Index(name="idSpeaker", columns={"idSpeaker"})})
 * @ORM\Entity
 */
class Conference
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idConference", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idconference;

    /**
     * @var string
     *
     * @ORM\Column(name="TitreConference", type="string", length=255, nullable=false)
     */
    private $titreconference;

    /**
     * @var string
     *
     * @ORM\Column(name="DescriptionConference", type="string", length=255, nullable=false)
     */
    private $descriptionconference;

    /**
     * @var string
     *
     * @ORM\Column(name="DateConference", type="string", length=255, nullable=false)
     */
    private $dateconference;

    /**
     * @var string
     *
     * @ORM\Column(name="HeureConference", type="string", length=255, nullable=false)
     */
    private $heureconference;

    /**
     * @var \Salle
     *
     * @ORM\ManyToOne(targetEntity="Salle")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="IdSalle", referencedColumnName="idSalle")
     * })
     */
    private $idsalle;

    /**
     * @var \Speaker
     *
     * @ORM\ManyToOne(targetEntity="Speaker")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idSpeaker", referencedColumnName="idspeaker")
     * })
     */
    private $idspeaker;


}

