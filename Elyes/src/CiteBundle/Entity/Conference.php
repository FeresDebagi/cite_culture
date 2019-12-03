<?php

namespace CiteBundle\Entity;

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
     * @var \DateTime
     *
     * @ORM\Column(name="DateConference", type="datetime", nullable=false)
     */
    private $dateconference;

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

    /**
     * @return int
     */
    public function getIdconference()
    {
        return $this->idconference;
    }

    /**
     * @param int $idconference
     */
    public function setIdconference($idconference)
    {
        $this->idconference = $idconference;
    }

    /**
     * @return string
     */
    public function getTitreconference()
    {
        return $this->titreconference;
    }

    /**
     * @param string $titreconference
     */
    public function setTitreconference($titreconference)
    {
        $this->titreconference = $titreconference;
    }

    /**
     * @return string
     */
    public function getDescriptionconference()
    {
        return $this->descriptionconference;
    }

    /**
     * @param string $descriptionconference
     */
    public function setDescriptionconference($descriptionconference)
    {
        $this->descriptionconference = $descriptionconference;
    }

    /**
     * @return \DateTime
     */
    public function getDateconference()
    {
        return $this->dateconference;
    }

    /**
     * @param \DateTime $dateconference
     */
    public function setDateconference($dateconference)
    {
        $this->dateconference = $dateconference;
    }

    /**
     * @return \Salle
     */
    public function getIdsalle()
    {
        return $this->idsalle;
    }

    /**
     * @param \Salle $idsalle
     */
    public function setIdsalle($idsalle)
    {
        $this->idsalle = $idsalle;
    }

    /**
     * @return \Speaker
     */
    public function getIdspeaker()
    {
        return $this->idspeaker;
    }

    /**
     * @param \Speaker $idspeaker
     */
    public function setIdspeaker($idspeaker)
    {
        $this->idspeaker = $idspeaker;
    }


}

