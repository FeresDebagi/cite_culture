<?php

namespace WebBundle\Entity;
use FOS\UserBundle\Model\User as BaseUser;



use Doctrine\ORM\Mapping as ORM;
use Mgilet\NotificationBundle\NotifiableInterface;

/**
 * User
 *
 * @ORM\Table(name="user")
 * @ORM\Entity
 */
class User  extends BaseUser
{

    /**
     * @var integer
     *
     * @ORM\Column(name="iduser", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    protected $id;

    /**
     * @var string
     *
     * @ORM\Column(name="loginuser", type="string", length=255, nullable=true)
     */
    private $loginuser;

    /**
     * @var string
     *
     * @ORM\Column(name="mdpuser", type="string", length=255, nullable=true)
     */
    private $mdpuser;

    /**
     * @var string
     *
     * @ORM\Column(name="mailuser", type="string", length=255, nullable=true)
     */
    private $mailuser;

    /**
     * @var string
     *
     * @ORM\Column(name="prenomuser", type="string", length=255, nullable=true)
     */
    private $prenomuser;

    /**
     * @var string
     *
     * @ORM\Column(name="nomuser", type="string", length=255, nullable=true)
     */
    private $nomuser;

    /**
     * @var integer
     *
     * @ORM\Column(name="cinuser", type="integer", nullable=true)
     */
    private $cinuser;

    /**
     * @var string
     *
     * @ORM\Column(name="datenaissanceuser", type="string", length=255, nullable=true)
     */
    private $datenaissanceuser;

    /**
     * @var integer
     *
     * @ORM\Column(name="numteluser", type="integer", nullable=true)
     */
    private $numteluser;

    /**
     * @var string
     *
     * @ORM\Column(name="photoprofiluser", type="string", length=50000, nullable=true)
     */
    private $photoprofiluser;

    /**
     * @var string
     *
     * @ORM\Column(name="roleuser", type="string", length=255, nullable=true)
     */
    private $roleuser;

    /**
     * User constructor.
     */
    public function __construct()
    {
        parent::__construct();
    }

    /**
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param int $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }


}

