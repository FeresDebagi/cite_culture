<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Formation
 *
 * @ORM\Table(name="formation", indexes={@ORM\Index(name="idSalle", columns={"idSalle"})})
 * @ORM\Entity
 */
class Formation
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_formation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idFormation;

    /**
     * @var string
     *
     * @ORM\Column(name="formateur_formation", type="string", length=255, nullable=true)
     */
    private $formateurFormation;

    /**
     * @var string
     *
     * @ORM\Column(name="classe_formation", type="string", length=255, nullable=true)
     */
    private $classeFormation;

    /**
     * @var float
     *
     * @ORM\Column(name="prix_formation", type="float", precision=10, scale=0, nullable=true)
     */
    private $prixFormation;

    /**
     * @var string
     *
     * @ORM\Column(name="type_formation", type="string", length=255, nullable=true)
     */
    private $typeFormation;

    /**
     * @var string
     *
     * @ORM\Column(name="DateFormation", type="string", length=255, nullable=false)
     */
    private $dateformation;

    /**
     * @var \Salle
     *
     * @ORM\ManyToOne(targetEntity="Salle")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idSalle", referencedColumnName="idSalle")
     * })
     */
    private $idsalle;


}

