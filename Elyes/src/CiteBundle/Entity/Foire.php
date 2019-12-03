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
    private $imageFoire;

    /**
     * @var string
     *
     * @ORM\Column(name="titre_foire", type="string", length=255, nullable=true)
     */
    private $titreFoire;

    /**
     * @var string
     *
     * @ORM\Column(name="date_foire", type="string", length=255, nullable=true)
     */
    private $dateFoire;

    /**
     * @var string
     *
     * @ORM\Column(name="heure_foire", type="string", length=255, nullable=true)
     */
    private $heureFoire;

    /**
     * @var integer
     *
     * @ORM\Column(name="prix_foire", type="integer", nullable=true)
     */
    private $prixFoire;

    /**
     * @var string
     *
     * @ORM\Column(name="salle_foire", type="string", length=255, nullable=true)
     */
    private $salleFoire;

    /**
     * @var string
     *
     * @ORM\Column(name="user_name_foire", type="string", length=255, nullable=true)
     */
    private $userNameFoire;

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
    public function getImageFoire()
    {
        return $this->imageFoire;
    }

    /**
     * @param string $imageFoire
     */
    public function setImageFoire($imageFoire)
    {
        $this->imageFoire = $imageFoire;
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
     * @return string
     */
    public function getDateFoire()
    {
        return $this->dateFoire;
    }

    /**
     * @param string $dateFoire
     */
    public function setDateFoire($dateFoire)
    {
        $this->dateFoire = $dateFoire;
    }

    /**
     * @return string
     */
    public function getHeureFoire()
    {
        return $this->heureFoire;
    }

    /**
     * @param string $heureFoire
     */
    public function setHeureFoire($heureFoire)
    {
        $this->heureFoire = $heureFoire;
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
     * @return string
     */
    public function getSalleFoire()
    {
        return $this->salleFoire;
    }

    /**
     * @param string $salleFoire
     */
    public function setSalleFoire($salleFoire)
    {
        $this->salleFoire = $salleFoire;
    }

    /**
     * @return string
     */
    public function getUserNameFoire()
    {
        return $this->userNameFoire;
    }

    /**
     * @param string $userNameFoire
     */
    public function setUserNameFoire($userNameFoire)
    {
        $this->userNameFoire = $userNameFoire;
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






}

