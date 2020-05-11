package com.br.lead.collector.services;

import com.br.lead.collector.models.Lead;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LeadService {

    private List<Lead> leads = new ArrayList(Arrays.asList(new Lead()));


}
