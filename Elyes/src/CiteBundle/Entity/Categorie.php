<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Categorie
 *
 * @ORM\Table(name="categorie")
 * @ORM\Entity
 */
class Categorie
{
    /**
     * @var integer
     *
     * @ORM\Column(name="IdCategorie", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idcategorie;

    /**
     * @var string
     *
     * @ORM\Column(name="TypeCategorie", type="string", length=255, nullable=false)
     */
    private $typecategorie;

//------------------------------------------------------------ Getters and Setters ---------------------------------------------

    /**
     * @return int
     */
    public function getIdcategorie()
    {
        return $this->idcategorie;
    }

    /**
     * @param int $idcategorie
     */
    public function setIdcategorie($idcategorie)
    {
        $this->idcategorie = $idcategorie;
    }

    /**
     * @return string
     */
    public function getTypecategorie()
    {
        return $this->typecategorie;
    }

    /**
     * @param string $typecategorie
     */
    public function setTypecategorie($typecategorie)
    {
        $this->typecategorie = $typecategorie;
    }





}

