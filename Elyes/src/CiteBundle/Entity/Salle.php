<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Salle
 *
 * @ORM\Table(name="salle")
 * @ORM\Entity
 */
class Salle
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idSalle", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idsalle;

    /**
     * @var integer
     *
     * @ORM\Column(name="numSalle", type="integer", nullable=false)
     */
    private $numsalle;


//------------------------------------------------------------ Getters and Setters ---------------------------------------------

    /**
     * @return int
     */
    public function getIdsalle()
    {
        return $this->idsalle;
    }

    /**
     * @param int $idsalle
     */
    public function setIdsalle($idsalle)
    {
        $this->idsalle = $idsalle;
    }

    /**
     * @return int
     */
    public function getNumsalle()
    {
        return $this->numsalle;
    }

    /**
     * @param int $numsalle
     */
    public function setNumsalle($numsalle)
    {
        $this->numsalle = $numsalle;
    }


}

