package fr.jcgay.maven.profiler.reporting;

import java.util.Collection;

import fr.jcgay.maven.profiler.reporting.template.Data;

public final class CompositeReporter implements Reporter {

	private final Collection<? extends Reporter> delegates;

	public CompositeReporter(Collection<? extends Reporter> delegates) {
		this.delegates = delegates;
	}

	@Override
	public void write(Data data, ReportDirectory directory) {
		for (Reporter r : delegates) {
			r.write(data, directory);
		}
	}

}
