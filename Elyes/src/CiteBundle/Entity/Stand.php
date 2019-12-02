<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Stand
 *
 * @ORM\Table(name="stand", indexes={@ORM\Index(name="IdU_fk", columns={"IdU_fk"})})
 * @ORM\Entity
 */
class Stand
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_stand", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idStand;

    /**
     * @var string
     *
     * @ORM\Column(name="titre_stand", type="string", length=255, nullable=false)
     */
    private $titreStand;

    /**
     * @var string
     *
     * @ORM\Column(name="proprietaire_stand", type="string", length=255, nullable=false)
     */
    private $proprietaireStand;

    /**
     * @var string
     *
     * @ORM\Column(name="type_marchandise", type="string", length=255, nullable=false)
     */
    private $typeMarchandise;

    /**
     * @var string
     *
     * @ORM\Column(name="date_debut_stand", type="string", length=255, nullable=false)
     */
    private $dateDebutStand;

    /**
     * @var string
     *
     * @ORM\Column(name="date_fin_stand", type="string", length=255, nullable=false)
     */
    private $dateFinStand;

    /**
     * @var integer
     *
     * @ORM\Column(name="IdU_fk", type="integer", nullable=false)
     */
    private $iduFk;

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


}

