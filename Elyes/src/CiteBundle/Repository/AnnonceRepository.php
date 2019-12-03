<?php

namespace CiteBundle\Repository;

use Doctrine\ORM\EntityRepository;
use CiteBundle\Entity\History;
use Doctrine\ORM\NonUniqueResultException;
use Doctrine\ORM\Query;
use CiteBundle\Entity\Evenement;

class AnnonceRepository extends EntityRepository
{

    /**
     * get all posts
     *
     * @return array
     */

    public function findByidEvent($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "DELETE 
                FROM CiteBundle:Inscription
                a WHERE a.id_event = :id_event")
            ->setParameter('id_event', $id)
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