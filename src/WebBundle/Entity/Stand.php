<?php

namespace WebBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Stand
 *
 * @ORM\Table(name="stand", indexes={@ORM\Index(name="IdU_fk", columns={"iduser"})})
 * @ORM\Entity
 */
class Stand
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idstand", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idstand;

    /**
     * @var string
     *
     * @ORM\Column(name="titrestand", type="string", length=255, nullable=false)
     */
    private $titrestand;

    /**
     * @var string
     *
     * @ORM\Column(name="proprietairestand", type="string", length=255, nullable=false)
     */
    private $proprietairestand;

    /**
     * @var string
     *
     * @ORM\Column(name="typemarchandise", type="string", length=255, nullable=false)
     */
    private $typemarchandise;

    /**
     * @var string
     *
     * @ORM\Column(name="datedebutstand", type="string", length=255, nullable=false)
     */
    private $datedebutstand;

    /**
     * @var string
     *
     * @ORM\Column(name="datefinstand", type="string", length=255, nullable=false)
     */
    private $datefinstand;

    /**
     * @var string
     *
     * @ORM\Column(name="PhotoStand", type="string", length=50000, nullable=true)
     */
    private $photostand;

    /**
     * @var string
     *
     * @ORM\Column(name="Actif", type="string", length=255, nullable=false)
     */
    private $actif;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="iduser", referencedColumnName="iduser")
     * })
     */
    private $iduser;


}

