package fr.univlille.iutinfo.m3105.utils;

public interface Observer {
        public void update(Subject subj);
        public void update(Subject subj, Object data);
}
