<?php

namespace CiteBundle\Repository;

use Doctrine\ORM\EntityRepository;
use CiteBundle\Entity\History;
use Doctrine\ORM\NonUniqueResultException;
use Doctrine\ORM\Query;

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
                "INSERT INTO CiteBundle:History (description_history, image_history, titre_history, IdCategorie)
                SELECT description_event, image_event, titre_event, IdCategorie
                FROM CiteBundle:Evenement e
                WHERE e.id_event = :id_event")
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