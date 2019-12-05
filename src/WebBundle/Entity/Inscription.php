<?php

namespace WebBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Inscription
 *
 * @ORM\Table(name="inscription", indexes={@ORM\Index(name="fk", columns={"iduser"}), @ORM\Index(name="fk1", columns={"idformation"}), @ORM\Index(name="fk2", columns={"idevent"})})
 * @ORM\Entity(repositoryClass="WebBundle\Repository\InscriptionRepository")
 */
class Inscription
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idinscription", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idinscription;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idevent", referencedColumnName="idevent")
     * })
     */
    private $idevent;

    /**
     * @var \Formation
     *
     * @ORM\ManyToOne(targetEntity="Formation")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idformation",  referencedColumnName="idformation")
     * })
     */
    private $idformation;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="iduser", referencedColumnName="iduser")
     * })
     */
    private $iduser;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateAjout", type="datetime", nullable=true)
     */
    private $dateajout = 'CURRENT_TIMESTAMP';

    public function __construct() {
        $this->dateajout = new \DateTime();
    }

    /**
     * @return int
     */
    public function getIdinscription()
    {
        return $this->idinscription;
    }

    /**
     * @param int $idinscription
     */
    public function setIdinscription($idinscription)
    {
        $this->idinscription = $idinscription;
    }

    /**
     * @return \Evenement
     */
    public function getIdevent()
    {
        return $this->idevent;
    }

    /**
     * @param \Evenement $idevent
     */
    public function setIdevent($idevent)
    {
        $this->idevent = $idevent;
    }

    /**
     * @return \Formation
     */
    public function getIdformation()
    {
        return $this->idformation;
    }



    /**
     * @param \Formation $idformation
     */
    public function setIdformation($idformation)
    {
        $this->idformation = $idformation;
    }

    /**
     * @return \User
     */
    public function getIduser()
    {
        return $this->iduser;
    }

    /**
     * @param \User $iduser
     */
    public function setIduser($iduser)
    {
        $this->iduser = $iduser;
    }

    /**
     * @return \DateTime
     */
    public function getDateajout()
    {
        return $this->dateajout;
    }

    /**
     * @param \DateTime $dateajout
     */
    public function setDateajout($dateajout)
    {
        $this->dateajout = $dateajout;
    }












}

