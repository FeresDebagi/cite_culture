<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * History
 *
 * @ORM\Table(name="history", indexes={@ORM\Index(name="IdCategorie", columns={"IdCategorie"})})
 * @ORM\Entity
 */
class History
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_history", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idHistory;

    /**
     * @var string
     *
     * @ORM\Column(name="description_history", type="string", length=255, nullable=true)
     */
    private $descriptionHistory;

    /**
     * @var string
     *
     * @ORM\Column(name="image_history", type="string", length=255, nullable=true)
     */
    private $image;

    /**
     * @var string
     *
     * @ORM\Column(name="titre_history", type="string", length=255, nullable=true)
     */
    private $titreHistory;

    /**
     * @var \Categorie
     *
     * @ORM\ManyToOne(targetEntity="Categorie")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="IdCategorie", referencedColumnName="IdCategorie")
     * })
     */
    private $idcategorie;

//------------------------------------------------------------ Getters and Setters ---------------------------------------------

    /**
     * @return int
     */
    public function getIdHistory()
    {
        return $this->idHistory;
    }

    /**
     * @param int $idHistory
     */
    public function setIdHistory($idHistory)
    {
        $this->idHistory = $idHistory;
    }

    /**
     * @return string
     */
    public function getDescriptionHistory()
    {
        return $this->descriptionHistory;
    }

    /**
     * @param string $descriptionHistory
     */
    public function setDescriptionHistory($descriptionHistory)
    {
        $this->descriptionHistory = $descriptionHistory;
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

    /**
     * @return string
     */
    public function getTitreHistory()
    {
        return $this->titreHistory;
    }

    /**
     * @param string $titreHistory
     */
    public function setTitreHistory($titreHistory)
    {
        $this->titreHistory = $titreHistory;
    }

    /**
     * @return \Categorie
     */
    public function getIdcategorie()
    {
        return $this->idcategorie;
    }

    /**
     * @param \Categorie $idcategorie
     */
    public function setIdcategorie($idcategorie)
    {
        $this->idcategorie = $idcategorie;
    }







}

