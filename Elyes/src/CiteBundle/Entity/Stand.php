<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Stand
 *
 * @ORM\Table(name="stand")
 * @ORM\Entity
 */
class Stand
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_stand", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idStand;

    /**
     * @var string
     *
     * @ORM\Column(name="titre_stand", type="string", length=255, nullable=false)
     */
    private $titreStand;

    /**
     * @var string
     *
     * @ORM\Column(name="proprietaire_stand", type="string", length=255, nullable=false)
     */
    private $proprietaireStand;

    /**
     * @var string
     *
     * @ORM\Column(name="type_marchandise", type="string", length=255, nullable=false)
     */
    private $typeMarchandise;

    /**
     * @var string
     *
     * @ORM\Column(name="date_debut_stand", type="string", length=255, nullable=false)
     */
    private $dateDebutStand;

    /**
     * @var string
     *
     * @ORM\Column(name="date_fin_stand", type="string", length=255, nullable=false)
     */
    private $dateFinStand;

    /**
     * @var string
     *
     * @ORM\Column(name="PhotoStand", type="string", length=255, nullable=true)
     */
    private $photostand;

    /**
     * @var string
     *
     * @ORM\Column(name="Actif", type="string", length=255, nullable=false)
     */
    private $actif;

//------------------------------------------------------------ Getters and Setters -------------------------------------------

    /**
     * @return int
     */
    public function getIdStand()
    {
        return $this->idStand;
    }

    /**
     * @param int $idStand
     */
    public function setIdStand($idStand)
    {
        $this->idStand = $idStand;
    }

    /**
     * @return string
     */
    public function getTitreStand()
    {
        return $this->titreStand;
    }

    /**
     * @param string $titreStand
     */
    public function setTitreStand($titreStand)
    {
        $this->titreStand = $titreStand;
    }

    /**
     * @return string
     */
    public function getProprietaireStand()
    {
        return $this->proprietaireStand;
    }

    /**
     * @param string $proprietaireStand
     */
    public function setProprietaireStand($proprietaireStand)
    {
        $this->proprietaireStand = $proprietaireStand;
    }

    /**
     * @return string
     */
    public function getTypeMarchandise()
    {
        return $this->typeMarchandise;
    }

    /**
     * @param string $typeMarchandise
     */
    public function setTypeMarchandise($typeMarchandise)
    {
        $this->typeMarchandise = $typeMarchandise;
    }

    /**
     * @return string
     */
    public function getDateDebutStand()
    {
        return $this->dateDebutStand;
    }

    /**
     * @param string $dateDebutStand
     */
    public function setDateDebutStand($dateDebutStand)
    {
        $this->dateDebutStand = $dateDebutStand;
    }

    /**
     * @return string
     */
    public function getDateFinStand()
    {
        return $this->dateFinStand;
    }

    /**
     * @param string $dateFinStand
     */
    public function setDateFinStand($dateFinStand)
    {
        $this->dateFinStand = $dateFinStand;
    }

    /**
     * @return string
     */
    public function getPhotostand()
    {
        return $this->photostand;
    }

    /**
     * @param string $photostand
     */
    public function setPhotostand($photostand)
    {
        $this->photostand = $photostand;
    }

    /**
     * @return string
     */
    public function getActif()
    {
        return $this->actif;
    }

    /**
     * @param string $actif
     */
    public function setActif($actif)
    {
        $this->actif = $actif;
    }






}

