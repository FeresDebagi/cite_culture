<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Formation
 *
 * @ORM\Table(name="formation", indexes={@ORM\Index(name="idSalle", columns={"idSalle"})})
 * @ORM\Entity
 *
 */
class Formation
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_formation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idformation;

    /**
     * @var string
     *
     * @ORM\Column(name="formateurformation", type="string", length=255, nullable=true)
     */
    private $formateurformation;

    /**
     * @var string
     *
     * @ORM\Column(name="classeformation", type="string", length=255, nullable=true)
     */
    private $classeformation;

    /**
     * @var float
     *
     * @ORM\Column(name="prixformation", type="float", precision=10, scale=0, nullable=true)
     */
    private $prixformation;

    /**
     * @var string
     *
     * @ORM\Column(name="typeformation", type="string", length=255, nullable=true)
     */
    private $typeformation;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="DateFormation", type="datetime", nullable=false)
     */
    private $dateformation;

    /**
     * @var \Salle
     *
     * @ORM\ManyToOne(targetEntity="Salle")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idSalle", referencedColumnName="idSalle")
     * })
     */
    private $idsalle;

    /**
     * @return int
     */
    public function getIdformation()
    {
        return $this->idformation;
    }

    /**
     * @param int $idformation
     */
    public function setIdformation($idformation)
    {
        $this->idformation = $idformation;
    }

    /**
     * @return string
     */
    public function getFormateurformation()
    {
        return $this->formateurformation;
    }

    /**
     * @param string $formateurformation
     */
    public function setFormateurformation($formateurformation)
    {
        $this->formateurformation = $formateurformation;
    }

    /**
     * @return string
     */
    public function getClasseformation()
    {
        return $this->classeformation;
    }

    /**
     * @param string $classeformation
     */
    public function setClasseformation($classeformation)
    {
        $this->classeformation = $classeformation;
    }

    /**
     * @return float
     */
    public function getPrixformation()
    {
        return $this->prixformation;
    }

    /**
     * @param float $prixformation
     */
    public function setPrixformation($prixformation)
    {
        $this->prixformation = $prixformation;
    }

    /**
     * @return string
     */
    public function getTypeformation()
    {
        return $this->typeformation;
    }

    /**
     * @param string $typeformation
     */
    public function setTypeformation($typeformation)
    {
        $this->typeformation = $typeformation;
    }

    /**
     * @return \DateTime
     */
    public function getDateformation()
    {
        return $this->dateformation;
    }

    /**
     * @param \DateTime $dateformation
     */
    public function setDateformation($dateformation)
    {
        $this->dateformation = $dateformation;
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


}

