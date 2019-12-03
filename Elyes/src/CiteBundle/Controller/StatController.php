<?php

namespace CiteBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use CiteBundle\Entity\Foire;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use CiteBundle\Form\FoireType;
use CiteBundle\Entity\Stand;
use Ob\HighchartsBundle\Highcharts\Highchart;

class StatController extends Controller
{
    public function StatAction()
    {
        $ob = new Highchart();
        $ob->chart->renderTo('linechart');
        $ob->title->text('Browser market shares at a specific website in 2010');
        $ob->plotOptions->pie(array(
            'allowPointSelect'  => true,
            'cursor'    => 'pointer',
            'dataLabels'    => array('enabled' => false),
            'showInLegend'  => true
        ));
        $data = array(
            array('Firefox', 45.0),
            array('IE', 26.8),
            array('Chrome', 12.8),
            array('Safari', 8.5),
            array('Opera', 6.2),
            array('Others', 0.7),
        );
        $ob->series(array(array('type' => 'pie','name' => 'Browser share', 'data' => $data)));
        return $this->render('@Cite/Foire/Stat.html.twig', array(
            'chart' => $ob
        ));
    }
}
