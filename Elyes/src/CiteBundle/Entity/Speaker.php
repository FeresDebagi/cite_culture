<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Speaker
 *
 * @ORM\Table(name="speaker", indexes={@ORM\Index(name="idU_fk", columns={"iduser"})})
 * @ORM\Entity
 */
class Speaker
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idspeaker", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idspeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="nomspeaker", type="string", length=255, nullable=true)
     */
    private $nomspeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="prenomspeaker", type="string", length=255, nullable=true)
     */
    private $prenomspeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="mailspeaker", type="string", length=255, nullable=true)
     */
    private $mailspeaker;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="datearrive", type="date", nullable=true)
     */
    private $datearrive;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="datedepart", type="date", nullable=true)
     */
    private $datedepart;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionspeaker", type="string", length=255, nullable=true)
     */
    private $descriptionspeaker;

    /**
     * @var string
     *
     * @ORM\Column(name="PhotoSpeaker", type="string", length=255, nullable=true)
     */
    private $photospeaker;

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
     * @var string
     *
     * @ORM\Column(name="image_speaker", type="string", length=255, nullable=true)
     */
    private $image;




    /**
     * @return int
     */
    public function getIdspeaker()
    {
        return $this->idspeaker;
    }

    /**
     * @param int $idspeaker
     */
    public function setIdspeaker($idspeaker)
    {
        $this->idspeaker = $idspeaker;
    }

    /**
     * @return string
     */
    public function getNomspeaker()
    {
        return $this->nomspeaker;
    }

    /**
     * @param string $nomspeaker
     */
    public function setNomspeaker($nomspeaker)
    {
        $this->nomspeaker = $nomspeaker;
    }

    /**
     * @return string
     */
    public function getPrenomspeaker()
    {
        return $this->prenomspeaker;
    }

    /**
     * @param string $prenomspeaker
     */
    public function setPrenomspeaker($prenomspeaker)
    {
        $this->prenomspeaker = $prenomspeaker;
    }

    /**
     * @return string
     */
    public function getMailspeaker()
    {
        return $this->mailspeaker;
    }

    /**
     * @param string $mailspeaker
     */
    public function setMailspeaker($mailspeaker)
    {
        $this->mailspeaker = $mailspeaker;
    }

    /**
     * @return \DateTime
     */
    public function getDatearrive()
    {
        return $this->datearrive;
    }

    /**
     * @param \DateTime $datearrive
     */
    public function setDatearrive($datearrive)
    {
        $this->datearrive = $datearrive;
    }

    /**
     * @return \DateTime
     */
    public function getDatedepart()
    {
        return $this->datedepart;
    }

    /**
     * @param \DateTime $datedepart
     */
    public function setDatedepart($datedepart)
    {
        $this->datedepart = $datedepart;
    }

    /**
     * @return string
     */
    public function getDescriptionspeaker()
    {
        return $this->descriptionspeaker;
    }

    /**
     * @param string $descriptionspeaker
     */
    public function setDescriptionspeaker($descriptionspeaker)
    {
        $this->descriptionspeaker = $descriptionspeaker;
    }

    /**
     * @return string
     */
    public function getPhotospeaker()
    {
        return $this->photospeaker;
    }

    /**
     * @param string $photospeaker
     */
    public function setPhotospeaker($photospeaker)
    {
        $this->photospeaker = $photospeaker;
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

