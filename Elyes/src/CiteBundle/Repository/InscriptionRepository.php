<?php


namespace CiteBundle\Repository;

use Doctrine\ORM\EntityRepository;
use CiteBundle\Entity\Inscription;
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
       FROM CiteBundle:Inscription
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
       FROM CiteBundle:Inscription
       a WHERE a.idformation = :idformation"
            )
            ->setParameter('idformation', $id)
            ->getResult();
    }



    public function findInscriptionByIddC($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM CiteBundle:InscriptionConference
       a WHERE a.iduser = :iduser"
            )
            ->setParameter('iduser', $id)
            ->getResult();
    }


    public function findInscriptionCByIdd($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM CiteBundle:InscriptionConference
       a WHERE a.idconference = :idconference"
            )
            ->setParameter('idconference', $id)
            ->getResult();
    }


    public function findInscriptionByIddE($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM CiteBundle:InscriptionEvent
       a WHERE a.iduser = :iduser"
            )
            ->setParameter('iduser', $id)
            ->getResult();
    }



    public function findInscriptionEByIdd($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM CiteBundle:InscriptionEvent
       a WHERE a.idevent = :idevent"
            )
            ->setParameter('idevent', $id)
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