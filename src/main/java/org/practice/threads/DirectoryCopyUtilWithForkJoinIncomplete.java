package org.practice.threads;

import java.io.File;
import java.util.concurrent.RecursiveAction;

public class DirectoryCopyUtilWithForkJoinIncomplete {

	static class DirectoryCopyTask extends RecursiveAction {
		private File source;
		private File dest;

		public DirectoryCopyTask(File source, File dest) {
			this.source = source;
			this.dest = dest;
		}
		
		public File getSource() {
			return source;
		}

		public void setSource(File source) {
			this.source = source;
		}

		public File getDest() {
			return dest;
		}

		public void setDest(File dest) {
			this.dest = dest;
		}

		@Override
		protected void compute() {
			if(source.exists() && source.isDirectory()) {
				dest.mkdir();
				for(File file : source.listFiles()) {
					
				}
				
			}
			
		}
		
	}
}
