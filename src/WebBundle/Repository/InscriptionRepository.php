<?php


namespace WebBundle\Repository;

use Doctrine\ORM\EntityRepository;
use WebBundle\Entity\Inscription;
use Doctrine\ORM\NonUniqueResultException;
use Doctrine\ORM\Query;



class InscriptionRepository extends EntityRepository
{
    /**
     * get all posts
     *
     * @return array
     */

    public function findInscriptionById($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM WebBundle:Inscription
       a WHERE a.iduser = :iduser"
            )
            ->setParameter('iduser', $id)
            ->getResult();
    }
    public function findInscriptionByIdd($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM WebBundle:Inscription
       a WHERE a.idformation = :idformation"
            )
            ->setParameter('idformation', $id)
            ->getResult();
    }

    public function findInscriptionBydate($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM WebBundle:Inscription
       a WHERE a.idformation = :idformation"
            )
            ->setParameter('idformation', $id)
            ->getResult();
    }



    /**
     * get one by id
     *
     * @param integer $id
     *
     * @return object or null
     */






}