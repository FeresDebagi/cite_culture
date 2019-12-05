<?php

namespace CiteBundle\Entity;
use Symfony\Component\Validator\Constraints as Assert;
use Doctrine\ORM\Mapping as ORM;

/**
 * Foire
 *
 * @ORM\Table(name="foire")
 * @ORM\Entity
 */

/**
 * Foire
 *
 * @ORM\Table(name="foire", indexes={@ORM\Index(name="idStand", columns={"idStand"})})
 * @ORM\Entity
 */

class Foire
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_foire", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idFoire;

    /**
     * @var string
     *
     * @ORM\Column(name="description_foire", type="string", length=255, nullable=true)
     * @Assert\NotBlank (message="le champ description est obligatoire")
     * @Assert\Length(min =5 ,max=30,
     *     minMessage="le titre doit contenir au moins 5 caractére",
     *     maxMessage="le titre doit contenir un maximum de 30 caractére")
     */
    private $descriptionFoire;

    /**
     * @var string
     *
     * @ORM\Column(name="image_foire", type="string", length=255, nullable=true)
     */
    private $image;

    /**
     * @var string
     *
     * @ORM\Column(name="titre_foire", type="string", length=255, nullable=true)
     */
    private $titreFoire;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="DateFoire", type="datetime", nullable=true)
     */
    private $dateFoire;

    /**
     * @var integer
     *
     * @ORM\Column(name="prix_foire", type="integer", nullable=true)
     */
    private $prixFoire;



    /**
     * @var \Stand
     *
     * @ORM\ManyToOne(targetEntity="Stand")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idStand", referencedColumnName="id_stand")
     * })
     */
    private $idStand;

//------------------------------------------------------------ Getters and Setters -------------------------------------------


    /**
     * @return int
     */
    public function getIdFoire()
    {
        return $this->idFoire;
    }

    /**
     * @param int $idFoire
     */
    public function setIdFoire($idFoire)
    {
        $this->idFoire = $idFoire;
    }

    /**
     * @return string
     */
    public function getDescriptionFoire()
    {
        return $this->descriptionFoire;
    }

    /**
     * @param string $descriptionFoire
     */
    public function setDescriptionFoire($descriptionFoire)
    {
        $this->descriptionFoire = $descriptionFoire;
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
    public function getTitreFoire()
    {
        return $this->titreFoire;
    }

    /**
     * @param string $titreFoire
     */
    public function setTitreFoire($titreFoire)
    {
        $this->titreFoire = $titreFoire;
    }



    /**
     * @return int
     */
    public function getPrixFoire()
    {
        return $this->prixFoire;
    }

    /**
     * @param int $prixFoire
     */
    public function setPrixFoire($prixFoire)
    {
        $this->prixFoire = $prixFoire;
    }



    /**
     * @return \Stand
     */
    public function getIdStand()
    {
        return $this->idStand;
    }

    /**
     * @param \Stand $idStand
     */
    public function setIdStand($idStand)
    {
        $this->idStand = $idStand;
    }

    /**
     * @return \DateTime
     */
    public function getDateFoire()
    {
        return $this->dateFoire;
    }

    /**
     * @param \DateTime $dateFoire
     */
    public function setDateFoire($dateFoire)
    {
        $this->dateFoire = $dateFoire;
    }







}

