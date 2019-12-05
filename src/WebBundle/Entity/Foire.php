<?php

namespace WebBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Foire
 *
 * @ORM\Table(name="foire")
 * @ORM\Entity
 */
class Foire
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idFoire", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idfoire;

    /**
     * @var string
     *
     * @ORM\Column(name="TypeFoire", type="string", length=255, nullable=false)
     */
    private $typefoire;


}

