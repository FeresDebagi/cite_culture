<?php

namespace WebBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Evenement
 *
 * @ORM\Table(name="evenement", indexes={@ORM\Index(name="IdCategorie", columns={"IdCategorie"})})
 * @ORM\Entity
 */
class Evenement
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idevent", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idevent;

    /**
     * @var string
     *
     * @ORM\Column(name="description_event", type="string", length=255, nullable=true)
     */
    private $descriptionEvent;

    /**
     * @var string
     *
     * @ORM\Column(name="imageevent", type="string", length=255, nullable=true)
     */
    private $imageevent;

    /**
     * @var string
     *
     * @ORM\Column(name="titreevent", type="string", length=255, nullable=true)
     */
    private $titreevent;

    /**
     * @var string
     *
     * @ORM\Column(name="dateevent", type="string", length=255, nullable=true)
     */
    private $dateevent;

    /**
     * @var string
     *
     * @ORM\Column(name="heureevent", type="string", length=255, nullable=true)
     */
    private $heureevent;

    /**
     * @var integer
     *
     * @ORM\Column(name="prixevent", type="integer", nullable=true)
     */
    private $prixevent;

    /**
     * @var string
     *
     * @ORM\Column(name="salleevent", type="string", length=255, nullable=true)
     */
    private $salleevent;

    /**
     * @var string
     *
     * @ORM\Column(name="usernameevent", type="string", length=255, nullable=true)
     */
    private $usernameevent;

    /**
     * @var \Categorie
     *
     * @ORM\ManyToOne(targetEntity="Categorie")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="IdCategorie", referencedColumnName="IdCategorie")
     * })
     */
    private $idcategorie;


}

