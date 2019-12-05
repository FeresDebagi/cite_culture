<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\HttpFoundation\File\File;
use Vich\UploaderBundle\Mapping\Annotation as Vich;


/**
 * Evenement
 *
 * @ORM\Table(name="evenement", indexes={@ORM\Index(name="IdCategorie", columns={"IdCategorie"})})
 * @ORM\Entity(repositoryClass="CiteBundle\Repository\AnnonceRepository")
 * @ORM\Entity
 * @Vich\Uploadable
 */
class Evenement
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_event", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idEvent;

    /**
     * @var string
     *
     * @ORM\Column(name="description_event", type="string", length=255, nullable=true)
     */
    private $descriptionEvent;

    /**
     * @var string
     *
     * @ORM\Column(name="titre_event", type="string", length=255, nullable=true)
     */
    private $titreEvent;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_event", type="datetime", nullable=true)
     */
    private $dateEvent;

    /**
     * @var integer
     *
     * @ORM\Column(name="prix_event", type="integer", nullable=true)
     */
    private $prixEvent;

    /**
     * @var integer
     *
     * @ORM\Column(name="salle_event", type="integer", nullable=true)
     */
    private $salleEvent;

    /**
     * @var string
     *
     * @ORM\Column(name="image_event", type="string", length=255, nullable=true)
     */
    private $image;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="updated_at", type="datetime", nullable=true)
     */
    private $updatedAt;

    /**
     * @var \Categorie
     *
     * @ORM\ManyToOne(targetEntity="Categorie")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="IdCategorie", referencedColumnName="IdCategorie")
     * })
     */
    private $idcategorie;


    /**
     * @Vich\UploadableField(mapping="event_images", fileNameProperty="image")
     * @var File
     */
    private $imageFile;

    /**
     * @var integer
     *
     * @ORM\Column(name="nbr", type="integer", nullable=true)
     */
    private $nbrE;






//------------------------------------------------------------ Getters and Setters ---------------------------------------------


    public function setImageFile(File $image = null)
    {
        $this->imageFile = $image;

        // VERY IMPORTANT:
        // It is required that at least one field changes if you are using Doctrine,
        // otherwise the event listeners won't be called and the file is lost
        if ($image) {
            // if 'updatedAt' is not defined in your entity, use another property
            $this->updatedAt = new \DateTime('now');
        }
    }

    public function getImageFile(){
        return $this->imageFile;
    }


    /**
     * @return int
     */
    public function getIdEvent()
    {
        return $this->idEvent;
    }

    /**
     * @param int $idEvent
     */
    public function setIdEvent($idEvent)
    {
        $this->idEvent = $idEvent;
    }

    /**
     * @return string
     */
    public function getDescriptionEvent()
    {
        return $this->descriptionEvent;
    }

    /**
     * @param string $descriptionEvent
     */
    public function setDescriptionEvent($descriptionEvent)
    {
        $this->descriptionEvent = $descriptionEvent;
    }

    /**
     * @return string
     */
    public function getTitreEvent()
    {
        return $this->titreEvent;
    }

    /**
     * @param string $titreEvent
     */
    public function setTitreEvent($titreEvent)
    {
        $this->titreEvent = $titreEvent;
    }

    /**
     * @return \DateTime
     */
    public function getDateEvent()
    {
        return $this->dateEvent;
    }

    /**
     * @param \DateTime $dateEvent
     */
    public function setDateEvent($dateEvent)
    {
        $this->dateEvent = $dateEvent;
    }

    /**
     * @return int
     */
    public function getPrixEvent()
    {
        return $this->prixEvent;
    }

    /**
     * @param int $prixEvent
     */
    public function setPrixEvent($prixEvent)
    {
        $this->prixEvent = $prixEvent;
    }

    /**
     * @return int
     */
    public function getSalleEvent()
    {
        return $this->salleEvent;
    }

    /**
     * @param int $salleEvent
     */
    public function setSalleEvent($salleEvent)
    {
        $this->salleEvent = $salleEvent;
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
     * @return \DateTime
     */
    public function getUpdatedAt()
    {
        return $this->updatedAt;
    }

    /**
     * @param \DateTime $updatedAt
     */
    public function setUpdatedAt($updatedAt)
    {
        $this->updatedAt = $updatedAt;
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

    /**
     * @return int
     */
    public function getNbrE()
    {
        return $this->nbrE;
    }

    /**
     * @param int $nbrE
     */
    public function setNbrE($nbrE)
    {
        $this->nbrE = $nbrE;
    }







}

