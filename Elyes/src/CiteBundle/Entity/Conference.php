<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

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
     * @ORM\Column(name="id_conference", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idconference;

    /**
     * @var string
     * @Assert\NotBlank (message="This Block is obligatory")
     * @Assert\Length(
     *     min =5,
     *     max=50,
     *     minMessage="Title must be longer that 5 charaters",
     *     maxMessage="Title must be shorter that 50 charaters"
     *     )
     * @ORM\Column(name="TitreConference", type="string", length=255, nullable=false)
     */
    private $titreconference;

    /**
     * @var string
     * @Assert\NotBlank (message="This Block is obligatory")
     * @Assert\Length(
     *     min =5,
     *     max=500,
     *     minMessage="Description must be longer that 5 charaters",
     *     maxMessage="Description must be shorter that 500 charaters"
     *     )
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
     *
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idSpeaker", referencedColumnName="idspeaker")
     * })
     */
    private $idspeaker;

    /**
     * @var float
     *
     *
     * @ORM\Column(name="nbr", type="integer", precision=10, scale=0, nullable=true)
     */
    private $nbrf;


    /**
     * @var string
     *
     * @ORM\Column(name="image_conference", type="string", length=255, nullable=true)
     */
    private $image;


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

    /**
     * @return float
     */
    public function getNbrf()
    {
        return $this->nbrf;
    }

    /**
     * @param float $nbrf
     */
    public function setNbrf($nbrf)
    {
        $this->nbrf = $nbrf;
    }

    /**
     * @return string
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * @param string $image
     */
    public function setImage($image)
    {
        $this->image = $image;
    }
}

