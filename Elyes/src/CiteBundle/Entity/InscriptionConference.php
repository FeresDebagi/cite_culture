<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * InscriptionConference
 * @ORM\Entity(repositoryClass="CiteBundle\Repository\InscriptionRepository")
 * @ORM\Table(name="inscriptionConference", indexes={@ORM\Index(name="iduser", columns={"iduser"}),
 *      @ORM\Index(name="id_conference", columns={"id_conference"})
 *     })
 */
class InscriptionConference
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
     * @var \Conference
     *
     * @ORM\ManyToOne(targetEntity="Conference")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_conference",  referencedColumnName="id_conference")
     * })
     */
    private $idconference;


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


//------------------------------------------------------------ Getters and Setters ---------------------------------------------


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

    /**
     * @return \Conference
     */
    public function getIdconference()
    {
        return $this->idconference;
    }

    /**
     * @param \Conference $idconference
     */
    public function setIdconference($idconference)
    {
        $this->idconference = $idconference;
    }





}