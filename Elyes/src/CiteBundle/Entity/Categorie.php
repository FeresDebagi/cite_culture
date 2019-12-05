<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

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
     * @Assert\NotBlank (message="This Block is obligatory")
     * @Assert\Length(
     *     min =5,
     *     max=50,
     *     minMessage="Type must be longer that 5 charaters",
     *     maxMessage="Type must be shorter that 50 charaters"
     *     )
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

